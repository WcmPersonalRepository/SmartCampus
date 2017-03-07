package com.nepo.weixin.util;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;
/**
 * 证书信任管理器（用于https请求） 1）支持HTTPS请求； 2）支持GET、POST两种方式； 3）支持参数提交，也支持无参数的情况；
 * 对于https请求，我们需要一个证书信任管理器，这个管理器类需要自己定义，但需要实现X509TrustManager接口
 * @author xpeng
 */
public class WeixinX509TrustManager implements X509TrustManager {
	@Override
	public void checkClientTrusted(X509Certificate[] chain, String authType)
		throws CertificateException {
	}
	@Override
	public void checkServerTrusted(X509Certificate[] chain, String authType)
		throws CertificateException {
	}
	@Override
	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}
}
