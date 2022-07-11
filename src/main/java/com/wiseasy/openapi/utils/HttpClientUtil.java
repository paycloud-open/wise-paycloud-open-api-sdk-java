package com.wiseasy.openapi.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Http tools, the retry mechanism is disabled by default
 * 
 * @author Jiangzj
 * @date 2019-06-03
 */
public class HttpClientUtil {

	public static final String DEFAULT_CHARSET = "UTF-8";

	public static final int DEFAULT_TIMEOUT = 30 * 1000;

	public static final String CONTENT_TYPE = "Content-Type";

	public static String doGet(String url) throws Exception {
		return doGet(url, null);
	}

	public static String doGet(String url, Map<String, Object> params) throws Exception {
		return doGet(url, null, params);
	}

	public static String doGet(String url, Map<String, Object> params, int connectTimeout, int readTimeout) throws Exception {
		return doGet(url, null, params, connectTimeout, readTimeout);
	}
	
	public static String doGet(String url, Map<String, Object> reqHeaders, Map<String, Object> params) throws Exception {
		return doGet(url, reqHeaders, null, params);
	}

	public static String doGet(String url, Map<String, Object> reqHeaders, Map<String, Object> params, int connectTimeout, int readTimeout) throws Exception {
		return doGet(url, reqHeaders, null, params, connectTimeout, readTimeout);
	}
	
	public static String doGet(String url, Map<String, Object> reqHeaders, Map<String, Object> respHeaders, Map<String, Object> params) throws Exception {
		return doGet(url, reqHeaders, respHeaders, params, DEFAULT_TIMEOUT, DEFAULT_TIMEOUT);
	}
	
	public static String doGet(String url, Map<String, Object> reqHeaders, Map<String, Object> respHeaders, Map<String, Object> params, int connectTimeout, int readTimeout) throws Exception {
		return doGet(url, reqHeaders, respHeaders, params, connectTimeout, readTimeout, DEFAULT_CHARSET, null, null);
	}

	public static String doGet(String url, Map<String, Object> reqHeaders, Map<String, Object> respHeaders, Map<String, Object> params, int connectTimeout, int readTimeout, String charset, String proxyHost, Integer proxyPort) throws Exception {
		URIBuilder builder = new URIBuilder();
		builder.setPath(url);
		builder.setParameters(params2nvps(params));
		builder.setCharset(Charset.forName(charset));

		HttpGet httpGet = new HttpGet(builder.build());

		return doRequest(url, reqHeaders, respHeaders, httpGet, connectTimeout, readTimeout, charset, proxyHost, proxyPort);
	}
	
	
	public static String doPost(String url) throws Exception {
		return doPost(url, null);
	}

	public static String doPost(String url, Map<String, Object> params) throws Exception {
		return doPost(url, null, params);
	}

	public static String doPost(String url, Map<String, Object> params, int connectTimeout, int readTimeout) throws Exception {
		return doPost(url, null, params, connectTimeout, readTimeout);
	}
	
	public static String doPost(String url, Map<String, Object> reqHeaders, Map<String, Object> params) throws Exception {
		return doPost(url, reqHeaders, null, params);
	}

	public static String doPost(String url, Map<String, Object> reqHeaders, Map<String, Object> params, int connectTimeout, int readTimeout) throws Exception {
		return doPost(url, reqHeaders, null, params, connectTimeout, readTimeout);
	}

	public static String doPost(String url, Map<String, Object> reqHeaders, Map<String, Object> respHeaders, Map<String, Object> params) throws Exception {
		return doPost(url, reqHeaders, respHeaders, params, DEFAULT_TIMEOUT, DEFAULT_TIMEOUT);
	}

	public static String doPost(String url, Map<String, Object> reqHeaders, Map<String, Object> respHeaders, Map<String, Object> params, int connectTimeout, int readTimeout) throws Exception {
		return doPost(url, reqHeaders, respHeaders, params, connectTimeout, readTimeout, DEFAULT_CHARSET, null, null);
	}

	public static String doPost(String url, Map<String, Object> reqHeaders, Map<String, Object> respHeaders, Map<String, Object> params, int connectTimeout, int readTimeout, String charset, String proxyHost, Integer proxyPort) throws Exception {
		HttpPost httpPost = new HttpPost(url);

		List<NameValuePair> pairs = params2nvps(params);
		if (pairs != null && pairs.size() > 0) {
			httpPost.setEntity(new UrlEncodedFormEntity(pairs, charset));
		}
		
		return doRequest(url, reqHeaders, respHeaders, httpPost, connectTimeout, readTimeout, charset, proxyHost, proxyPort);
	}
	
	
	public static String doPostStr(String url, String data) throws Exception {
		return doPostStr(url, null, data);
	}
	
	public static String doPostStr(String url, String data, int connectTimeout, int readTimeout) throws Exception {
		return doPostStr(url, null, data, connectTimeout, readTimeout);
	}
	
	public static String doPostStr(String url, Map<String, Object> reqHeaders, String data) throws Exception {
		return doPostStr(url, reqHeaders, null, data);
	}

	public static String doPostStr(String url, Map<String, Object> reqHeaders, String data, int connectTimeout, int readTimeout) throws Exception {
		return doPostStr(url, reqHeaders, null, data, connectTimeout, readTimeout);
	}
	
	public static String doPostStr(String url, Map<String, Object> reqHeaders, Map<String, Object> respHeaders, String data) throws Exception {
		return doPostStr(url, reqHeaders, respHeaders, data, DEFAULT_TIMEOUT, DEFAULT_TIMEOUT);
	}

	public static String doPostStr(String url, Map<String, Object> reqHeaders, Map<String, Object> respHeaders, String data, int connectTimeout, int readTimeout) throws Exception {
		return doPostStr(url, reqHeaders, respHeaders, data, connectTimeout, readTimeout, DEFAULT_CHARSET, null, null);
	}

	public static String doPostStr(String url, Map<String, Object> reqHeaders, Map<String, Object> respHeaders, String data, int connectTimeout, int readTimeout, String charset, String proxyHost, Integer proxyPort) throws Exception {
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new StringEntity(data, charset));

		return doRequest(url, reqHeaders, respHeaders, httpPost, connectTimeout, readTimeout, charset, proxyHost, proxyPort);
	}
	

	public static String doPostJson(String url, Map<String, Object> params) throws Exception {
		return doPostJson(url, null, params);
	}
	
	public static String doPostJson(String url, Map<String, Object> params, int connectTimeout, int readTimeout) throws Exception {
		return doPostJson(url, null, params, connectTimeout, readTimeout);
	}
	
	public static String doPostJson(String url, Map<String, Object> reqHeaders, Map<String, Object> params) throws Exception {
		return doPostJson(url, reqHeaders, null, params);
	}

	public static String doPostJson(String url, Map<String, Object> reqHeaders, Map<String, Object> params, int connectTimeout, int readTimeout) throws Exception {
		return doPostJson(url, reqHeaders, null, params, connectTimeout, readTimeout);
	}
	
	public static String doPostJson(String url, Map<String, Object> reqHeaders, Map<String, Object> respHeaders, Map<String, Object> params) throws Exception {
		return doPostJson(url, reqHeaders, respHeaders, params, DEFAULT_TIMEOUT, DEFAULT_TIMEOUT);
	}

	public static String doPostJson(String url, Map<String, Object> reqHeaders, Map<String, Object> respHeaders, Map<String, Object> params, int connectTimeout, int readTimeout) throws Exception {
		return doPostJson(url, reqHeaders, respHeaders, params, connectTimeout, readTimeout, DEFAULT_CHARSET, null, null);
	}

	public static String doPostJson(String url, Map<String, Object> reqHeaders, Map<String, Object> respHeaders, Map<String, Object> params, int connectTimeout, int readTimeout, String charset, String proxyHost, Integer proxyPort) throws Exception {
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader(CONTENT_TYPE, "application/json; charset=" + charset);
		httpPost.setEntity(new StringEntity(JSON.toJSONString(params), charset));

		return doRequest(url, reqHeaders, respHeaders, httpPost, connectTimeout, readTimeout, charset, proxyHost, proxyPort);
	}

	public static String doPostFile(String url, Map<String, Object> reqHeaders, Map<String, Object> params, Map<String, FileBody> fileParams) throws Exception {
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setCharset(Charset.forName(DEFAULT_CHARSET));
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

		if (params != null && !params.isEmpty()) {
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				builder.addTextBody(entry.getKey(), String.valueOf(entry.getValue()));
			}
		}

		if (fileParams != null && !fileParams.isEmpty()) {
			for (Map.Entry<String, FileBody> entry : fileParams.entrySet()) {
				FileBody fileBody = entry.getValue();
				builder.addBinaryBody(entry.getKey(), fileBody.getFile(), fileBody.getContentType(), fileBody.getFilename());
			}
		}

		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(builder.build());

		return doRequest(url, reqHeaders, null, httpPost, DEFAULT_TIMEOUT * 2, DEFAULT_TIMEOUT * 2, DEFAULT_CHARSET, null, null);
	}

	private static String doRequest(String url, Map<String, Object> reqHeaders, Map<String, Object> respHeaders, HttpRequestBase request, int connectTimeout, int readTimeout, String charset, String proxyHost, Integer proxyPort) throws Exception {
		HttpHost proxy = null;
		if (StringUtils.isNotBlank(proxyHost)) {
			proxy = new HttpHost(proxyHost, proxyPort);
		}
		return doRequest(url, reqHeaders, respHeaders, request, connectTimeout, readTimeout, charset, proxy);
	}
	
	private static String doRequest(String url, Map<String, Object> reqHeaders, Map<String, Object> respHeaders, HttpRequestBase request, int connectTimeout, int readTimeout, String charset, HttpHost proxy) throws Exception {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse httpResponse = null;
		try {
			RequestConfig.Builder configBuilder = RequestConfig.custom();
			configBuilder.setConnectionRequestTimeout(connectTimeout);// 设置从连接池获取连接实例的超时
			configBuilder.setConnectTimeout(connectTimeout);// 设置连接超时
			configBuilder.setSocketTimeout(readTimeout);// 设置读取超时
			if (proxy != null) {
				configBuilder.setProxy(proxy); // 设置代理
			}
			request.setConfig(configBuilder.build());

			if (reqHeaders != null) {
				for (Map.Entry<String, Object> header : reqHeaders.entrySet()) {
					Object v = header.getValue();
					if (v != null) {
						request.setHeader(header.getKey(), v.toString());
					}
				}
			}

			httpClient = getHttpClient(url);
			httpResponse = httpClient.execute(request);

			if (respHeaders != null) {
				if (httpResponse != null) {
					Header[] headers = httpResponse.getAllHeaders();
					for (Header header : headers) {
						respHeaders.put(header.getName(), header.getValue());
					}
				}
			}

			HttpEntity entity = httpResponse.getEntity();
			return EntityUtils.toString(entity, charset);
		} finally {
			if (httpResponse != null) {
				HttpClientUtils.closeQuietly(httpResponse);
			}
			if (httpClient != null) {
				HttpClientUtils.closeQuietly(httpClient);
			}
		}
	}

	private static List<NameValuePair> params2nvps(Map<String, Object> params) {
		List<NameValuePair> pairList = new ArrayList<NameValuePair>();
		if (params != null) {
			for (Map.Entry<String, Object> param : params.entrySet()) {
				Object v = param.getValue();
				if (v != null) {
					pairList.add(new BasicNameValuePair(param.getKey(), v.toString()));
				}
			}
		}
		return pairList;
	}

	private static CloseableHttpClient getHttpClient(String url) throws Exception {
		HttpClientBuilder httpClientBuilder = HttpClients.custom().disableAutomaticRetries();
		
		boolean isSSL = url.startsWith("https");
		if (isSSL) {
			SSLContextBuilder contextBuilder = new SSLContextBuilder().loadTrustMaterial(null,
					new TrustStrategy() {
						@Override
						public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
							return true;
						}
					});
			SSLConnectionSocketFactory sslf = new SSLConnectionSocketFactory(contextBuilder.build(),
					new String[]{"TLSv1.2"},
					null,
					new HostnameVerifier() {
						@Override
						public boolean verify(String host, SSLSession sslSession) {
							return true;
						}
					});
			httpClientBuilder.setSSLSocketFactory(sslf);
		}
		
		return httpClientBuilder.build();
	}
}