package com.gxufe.smarcampus.common.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetUtils {

	public static String getNetData(String path) {
		String str = "";
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5 * 1000);
			InputStream inStream = conn.getInputStream();
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = inStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, len);
			}
			str = outStream.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * post数据链接
	 * 
	 * @param data
	 * @param url
	 * @return String
	 * @throws Exception
	 */
	public static String doPostData(String data, String url) throws Exception {
		URL httpUrl = new URL(url);
		HttpURLConnection hc = (HttpURLConnection) httpUrl.openConnection();
		hc.setDoOutput(true);
		hc.setDoInput(true);
		hc.setRequestMethod("POST");
		hc.setRequestProperty("Content-Type", "application/octet-stream");

		byte[] bits = data.getBytes("UTF-8");
		if (bits != null) {
			hc.setRequestProperty("Content-Length", String.valueOf(bits.length));
		}
		OutputStream out = hc.getOutputStream();
		if (bits != null) {
			out.write(bits);
		}
		out.flush();

		InputStream input = hc.getInputStream();
		ByteArrayOutputStream byteArr = new ByteArrayOutputStream();
		byte[] bytes = new byte[1024];
		int k = 0;
		while ((k = input.read(bytes)) != -1) {
			byteArr.write(bytes, 0, k);
		}
		byteArr.flush();

		byte[] returnDatas = byteArr.toByteArray();
		byteArr.close();
		input.close();
		out.close();
		String rtData = new String(returnDatas, "UTF-8");

		return rtData;
	}
}
