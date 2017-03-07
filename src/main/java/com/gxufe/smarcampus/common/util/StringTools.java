package com.gxufe.smarcampus.common.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class StringTools {

    /**
     * 将中文字符串转换为汉语拼音
     */
    public static String hanyuToPinyin(String value) {

        if (StringUtils.isBlank(value)) {
            return value;
        }

        StringBuffer pinyin = new StringBuffer("");

        char[] chars = value.toCharArray();
        HanyuPinyinOutputFormat out = new HanyuPinyinOutputFormat();
        out.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        out.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        out.setVCharType(HanyuPinyinVCharType.WITH_V);
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (String.valueOf(c).matches("[\\u4E00-\\u9FA5]+")) {
                String[] pingyins = null;
                try {
                    pingyins = PinyinHelper.toHanyuPinyinStringArray(c, out);
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
                if (pingyins != null) {
                    pinyin.append(pingyins[0]).append(" ");
                }
            } else if ((String.valueOf(c).matches("[0-9a-zA-Z]+"))) {
                pinyin.append(c);
            } else {
                pinyin.append(" ");
            }
        }
        return pinyin.toString().replaceAll("  ", " ").trim();
    }

    public static String encoded(String str) {
        if (StringUtils.isNoneBlank(str)) {
            try {
                str = StringUtils.toEncodedString(str.getBytes("iso-8859-1"),
                        Charset.defaultCharset());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    /**
     * 检查字符串是否为空，非空为true
     * 
     * @param str
     * @return boolean
     */
    public static boolean checkEmpty(String str) {
        return (str != null && !"".equals(str.trim()) && !"null".equals(str.trim()));
    }

    /**
     *  HTML encoding (does not convert line breaks).
     *  Replaces all '&gt;' '&lt;' '&amp;' and '"' with entity reference
     */
    public static String htmlspecialchars(String s) {
        int ln = s.length();
        for (int i = 0; i < ln; i++) {
            char c = s.charAt(i);
            if (c == '<' || c == '>' || c == '&' || c == '"' || c == '\'') {
                StringBuffer b = new StringBuffer(s.substring(0, i));
                switch (c) {
                case '<':
                    b.append("&lt;");
                    break;
                case '>':
                    b.append("&gt;");
                    break;
                case '&':
                    b.append("&amp;");
                    break;
                case '"':
                    b.append("&quot;");
                    break;
                case '\'':
                    b.append("&#039;");
                    break;
                }
                i++;
                int next = i;
                while (i < ln) {
                    c = s.charAt(i);
                    if (c == '<' || c == '>' || c == '&' || c == '"' || c == '\'') {
                        b.append(s.substring(next, i));
                        switch (c) {
                        case '<':
                            b.append("&lt;");
                            break;
                        case '>':
                            b.append("&gt;");
                            break;
                        case '&':
                            b.append("&amp;");
                            break;
                        case '"':
                            b.append("&quot;");
                            break;
                        case '\'':
                            b.append("&#039;");
                            break;
                        }
                        next = i + 1;
                    }
                    i++;
                }
                if (next < ln)
                    b.append(s.substring(next));
                s = b.toString();
                break;
            } // if c ==
        } // for
        return s;
    }

    /**
     * 截取字符串，并在截取的字符串后添加指定后缀，如果字符串长度小于 指定长度时不添加后缀原样返回。
     * 
     * @param str    需要截取的字符串
     * @param length 截取字符串的长度，字母算 1 个字，全角字符算 2 个字
     * @param suffix 超出时添加的后缀
     * @return String
     * 
     */
    public static String truncate(String str, int length, String suffix) {
        if ((str == null) || (str.length() == 0) || (length < 1)) {
            return str;
        }
        char[] chs = str.toCharArray();
        int offset = 0;
        for (int len = 0; offset < chs.length; offset++) {
            len += (chs[offset] > 0xff) ? 2 : 1;
            if (len > length) {
                break;
            }
        }
        if (offset == chs.length) {
            return str;
        }
        if (suffix == null || suffix.trim().length() == 0) {
            return new String(chs, 0, offset);
        }
        return new String(chs, 0, offset) + suffix.trim();
    }

    /**
     * 生成指定范围长度的字符串
     * 
     * @param start
     * @param end
     * @return String
     */
    public static String getRandomString(int start, int end) {
        int length = start + (int) (Math.random() * end);
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
    
    /**
     * 返回长度为【strLength】的随机数，在前面补0
     *
     * @param strLength
     * @return
     * @date 2016-8-3
     */
    public static String getFixLenthRandom(int length) {
        Random rm = new Random();
        // 获得随机数
        double pross = (1 + rm.nextDouble()) * Math.pow(10, length);

        // 将获得的获得随机数转化为字符串
        String fixLenthString = String.valueOf(pross);

        // 返回固定的长度的随机数
        return fixLenthString.substring(1, length + 1);
    }

    /**
     * XML格式化输出
     * @param document
     */
    public static String formatXml(String xml) {
        if (!StringTools.checkEmpty(xml) || xml.length() < 8) {
            return xml;
        }

        xml = xmlEscape(xml, true);
        // 创建格式设置编码
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        format.setExpandEmptyElements(true);
        format.setTrimText(false);
        format.setIndent(true);

        // 创建writer
        StringWriter writer = new StringWriter();
        XMLWriter xmlWriter = new XMLWriter(writer, format);

        try {
            Document document = DocumentHelper.parseText(xml);
            xmlWriter.write(document);
            xmlWriter.close();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xmlEscape(writer.toString(), false);
    }

    /**
     * 转义XML中特殊字符
     * @param content
     * @param flag
     * @return String
     */
    public static String xmlEscape(String content, boolean flag) {
        if (flag) {
            content = content.replaceAll("&", "&amp;");
        } else {
            content = content.replaceAll("&amp;", "&");
        }
        return content;
    }

    /**
     * 转换成UTF-8
     * @return String
     */
    public static String stringEncoding2UTF8(String str) {
        if (!StringTools.checkEmpty(str)) {
            return str;
        }

        StringBuffer buffer = new StringBuffer();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(
                    str.getBytes()), "UTF-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer.toString();
    }

    public static String getEncoding(String str) {
        if (!StringTools.checkEmpty(str)) {
            return str;
        }

        try {
            String encode = "GB2312";
            if (str.equals(new String(str.getBytes(encode), encode))) {
                return encode;
            }

            encode = "ISO-8859-1";
            if (str.equals(new String(str.getBytes(encode), encode))) {
                return encode;
            }

            encode = "UTF-8";
            if (str.equals(new String(str.getBytes(encode), encode))) {
                return encode;
            }

            encode = "GBK";
            if (str.equals(new String(str.getBytes(encode), encode))) {
                return encode;
            }

            encode = "EUC-CN";
            if (str.equals(new String(str.getBytes(encode), encode))) {
                return encode;
            }

            encode = "EUC-TW";
            if (str.equals(new String(str.getBytes(encode), encode))) {
                return encode;
            }

            encode = "EUC-JP";
            if (str.equals(new String(str.getBytes(encode), encode))) {
                return encode;
            }

            encode = "BIG-5";
            if (str.equals(new String(str.getBytes(encode), encode))) {
                return encode;
            }

            encode = "SJIS";
            if (str.equals(new String(str.getBytes(encode), encode))) {
                return encode;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取IP段List
     * @param startIP
     * @param endIP
     * @param ipNum
     * @return List
     */
    public static List<String> getIPListFromSegment(String startIP, String endIP, int ipNum) {
        // 校验参数有效性
        if (!checkEmpty(startIP) || !checkEmpty(endIP)) {
            return null;
        }
        if (!isIPAddress(startIP) || !isIPAddress(endIP)) {
            return null;
        }

        long head = ip2long(startIP);
        // 获取IP段数量
        long count = ip2long(endIP) - head + 1;
        if (count > ipNum) {
            count = ipNum;
        }

        List<String> list = new ArrayList<String>();
        // 跨段去除末位0、255
        for (int i = 0; i < count; i++) {
            String ip = long2ip((head + i));
            String lastIp = ip.substring(ip.lastIndexOf(".") + 1);
            if ("0".equals(lastIp) || "255".equals(lastIp)) {
                continue;
            }
            list.add(ip);
        }
        return list;
    }

    /**
     * IP格式校验
     * @param ipAddress
     * @return true|false
     */
    public static boolean isIPAddress(String ipAddress) {
        String ip = "(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})";
        Pattern pattern = Pattern.compile(ip);
        Matcher matcher = pattern.matcher(ipAddress);
        return matcher.matches();
    }

    /**
     * IP转换长整形
     * @param ipString
     * @return long
     */
    public static long ip2long(String ipString) {
        long result = 0;
        java.util.StringTokenizer token = new java.util.StringTokenizer(ipString, ".");
        result += Long.parseLong(token.nextToken()) << 24;
        result += Long.parseLong(token.nextToken()) << 16;
        result += Long.parseLong(token.nextToken()) << 8;
        result += Long.parseLong(token.nextToken());
        return result;
    }

    /**
     * 长整形转换为IP
     * @param ipLong
     * @return String
     */
    public static String long2ip(long ipLong) {
        StringBuilder sb = new StringBuilder();
        sb.append(ipLong >>> 24);
        sb.append(".");
        sb.append(String.valueOf((ipLong & 0x00FFFFFF) >>> 16));
        sb.append(".");
        sb.append(String.valueOf((ipLong & 0x0000FFFF) >>> 8));
        sb.append(".");
        sb.append(String.valueOf(ipLong & 0x000000FF));
        return sb.toString();
    }

    /**
     * 去除Arrays中空值和重复元素
     * @param strs
     * @return String[]
     */
    public static String[] arrayTrim(String[] strs) {
        if (strs == null) {
            return null;
        }

        StringBuilder str = new StringBuilder();
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            if (StringTools.checkEmpty(strs[i])) {
                str.append(strs[i]).append("|");
            }
        }

        return str.toString().split("\\|");
    }

    /**
     * 判断两数组是否相同内容  
     * @param array1
     * @param array2
     * @return true|false
     * @author JIANGZHE-01
     * @date 2015-1-12
     */
    public static <T> boolean isSameContentArray(T[] array1, T[] array2) {
        if (array1 == null || array2 == null) {
            return false;
        }
        Arrays.sort(array1);
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }
    
	public static String[] CHARS = new String[] { "a", "b", "c", "d", "e", "f",
			"g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
			"t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z" };
	
	/**
	 * 获取流水号
	 * 
	 * @return String
	 * @date 2016-7-18
	 */
	public static String getSerialNumber() {
		StringBuilder sb = new StringBuilder();
		sb.append(System.currentTimeMillis());
		
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int strInteger = Integer.parseInt(str, 16);
			sb.append(CHARS[strInteger % 0x3E]);
		}

		return sb.toString();
	}
	
	/**
	 * 正则校验
	 * @param exp
	 * @param data
	 * @return true|false
	 * @date 2016-7-21
	 */
	public static boolean formatValidate(String data, String exp) {
		if (StringUtils.isBlank(data) || StringUtils.isBlank(exp)) {
			return false;
		}

		Pattern pattern = Pattern.compile(exp);
		Matcher matcher = pattern.matcher(data);
		return matcher.matches();
	}
	
	public static void main(String[] args) {
		System.out.println(getRandomNumber(4));
	}

	//产生随机数字字符串
	public static String getRandomNumber(int length) {
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < length; i++) {
			int num=(int) (Math.random()*10);
			sb.append(num);
		}
		return sb.toString();
	}

}
