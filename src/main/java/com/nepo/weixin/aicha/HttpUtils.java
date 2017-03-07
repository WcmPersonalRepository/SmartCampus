package com.nepo.weixin.aicha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import com.nepo.weixin.constants.WeiXinConstants;

public class HttpUtils {

	private static Logger logger = Logger.getLogger(HttpUtils.class);

	/**
	 * 
	 * @param url
	 * @param encoding
	 * @return String
	 * @throws Exception
	 */
	public static String getUrl(String url, String encoding) throws Exception {
		HttpClient client = new DefaultHttpClient();
		HttpGet get = null;
		HttpResponse response = null;
		InputStreamReader reader = null;
		InputStream in = null;
		StringBuffer content = new StringBuffer();

		try {
			get = new HttpGet(url);
			response = client.execute(get);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				in = entity.getContent();

				reader = new InputStreamReader(in, encoding);

				char[] c = new char[1024];
				int count = 0;
				while ((count = reader.read(c)) != -1) {
					content.append(new String(c, 0, count));
				}
			} else {
				return null;
			}
		} catch (ClientProtocolException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}

			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}

			if (get != null) {
				get.abort();
			}
			client.getConnectionManager().shutdown();
		}
		return content.toString();
	}

	/**
	 * 
	 * @param url
	 * @param paramName
	 * @param jsonparam
	 * @return String
	 * @throws Exception
	 */
	public static String postUrl(String url, String paramName, String jsonparam)
			throws Exception {
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		InputStreamReader reader = null;
		InputStream in = null;

		StringBuffer content = new StringBuffer();
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		if (paramName != null)
			nvps.add(new BasicNameValuePair(paramName, jsonparam));

		try {
			post.setEntity(new UrlEncodedFormEntity(nvps,
					WeiXinConstants.ENCODING));
			HttpResponse response = client.execute(post);
			HttpEntity entity = response.getEntity();
			in = entity.getContent();

			reader = new InputStreamReader(in, WeiXinConstants.ENCODING);
			char[] c = new char[1024];
			int count = 0;
			while ((count = reader.read(c)) != -1) {
				content.append(new String(c, 0, count));
			}
		} catch (ClientProtocolException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}

			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}

			if (post != null) {
				post.abort();
			}
			client.getConnectionManager().shutdown();
		}
		return content.toString();
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param) {
		BufferedReader in = null;
		String result = "";
		OutputStream out = null;
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("Content-Type",
					"application/json;charset=UTF-8");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = conn.getOutputStream();
			out.write(param.getBytes("UTF-8"));
			// flush输出流的缓冲
			out.flush();
			out.close();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream(),"UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("POST数据成功：" + result);
		return result;
	}

	public static String inputStream2String(InputStream in) throws IOException {
		StringBuffer out = new StringBuffer();
		byte[] b = new byte[4096];
		for (int n; (n = in.read(b)) != -1;) {
			out.append(new String(b, 0, n));
		}
		return out.toString();
	}
}
