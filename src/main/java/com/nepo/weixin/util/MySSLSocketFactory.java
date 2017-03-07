package com.nepo.weixin.util;
/**
 * 这里是证书的一个工厂类,用来实现证书的创建
 * @author credream
 */
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.apache.http.conn.ssl.SSLSocketFactory;
@SuppressWarnings("deprecation")
public class MySSLSocketFactory extends SSLSocketFactory {
	static {
		mySSLSocketFactory = new MySSLSocketFactory(createSContext());
	}
	private static MySSLSocketFactory mySSLSocketFactory = null;
	private static SSLContext createSContext() {
		SSLContext sslcontext = null;
		try {
			sslcontext = SSLContext.getInstance("SSL");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		try {
			sslcontext.init(null, new TrustManager[] { new WeixinX509TrustManager() }, null);
		} catch (KeyManagementException e) {
			e.printStackTrace();
			return null;
		}
		return sslcontext;
	}
	@SuppressWarnings("deprecation")
	private MySSLSocketFactory(SSLContext sslContext) {
		super(sslContext);
		this.setHostnameVerifier(ALLOW_ALL_HOSTNAME_VERIFIER);
	}
	public static MySSLSocketFactory getInstance() {
		if (mySSLSocketFactory != null) {
			return mySSLSocketFactory;
		} else {
			return mySSLSocketFactory = new MySSLSocketFactory(createSContext());
		}
	}
}
