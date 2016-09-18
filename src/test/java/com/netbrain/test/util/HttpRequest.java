package com.netbrain.test.util;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.execchain.RequestAbortedException;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author gaohuan
 *
 * 2016年9月12日下午8:37:22
 */
public class HttpRequest {
	
	private final static Logger logger=LoggerFactory.getLogger(HttpRequest.class);
	private static final  CloseableHttpClient httpClient;
	
	static{
		RequestConfig config=RequestConfig.custom().setConnectTimeout(60000).setSocketTimeout(15000).build();
		httpClient=HttpClientBuilder.create().setDefaultRequestConfig(config).build();
	}
	
	public static final String CHARSET_utf="utf-8";
	public static final String CHARSET_gbk = "GBK";
	
	/**
     * HTTP Post 获取内容
     *
     * @param url     请求的url地址 ?之前的地址
     * @param params  表单参数
     * @param heads   请求的头
     * @param charset 编码格式
     * @return 页面内容
     */
    public static String doPostFormWithHeader(String url, Map<String, Object> params, Map<String, String> heads, String charset) {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        System.out.println(url);
        try {
            HttpPost httpPost = new HttpPost(url);

            List<NameValuePair> pairs = null;
            if (params != null && !params.isEmpty()) {
                pairs = new ArrayList<NameValuePair>(params.size());
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    String value = entry.getValue().toString();
                    if (value != null) {
                        pairs.add(new BasicNameValuePair(entry.getKey(), value));
                    }
                }
            }
            if (pairs != null && pairs.size() > 0) {
                httpPost.setEntity(new UrlEncodedFormEntity(pairs, CHARSET_utf));
            }

            if (heads != null) {
                for (Entry<String, String> e : heads.entrySet()) {
                    httpPost.addHeader(e.getKey(), e.getValue());
                }
            }
            CloseableHttpResponse response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpPost.abort();

                throw new RuntimeException("HttpClient,error status code :" + statusCode);
            }
            HttpEntity entity = response.getEntity();
            String result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, "utf-8");
            }
            EntityUtils.consume(entity);
            response.close();
            return result;
        } catch (Exception e) {
            if (e instanceof RequestAbortedException || e instanceof SocketTimeoutException || e instanceof SocketException) {
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                return doPostFormWithHeader(url, params, heads, charset);
            }
            e.printStackTrace();
        }
        return null;
    }

	
	
	
	
	/**
     * HTTP Post 获取内容
     *
     * @param params  请求的实体数据，非表单参数
     * @param heads   请求的头
     * @param charset 编码格式
     * @return 页面内容
     */
    public static String doPostBody(String urlInit, Map<String, Object> params, Map<String, String> heads, String charset) {
    	if (StringUtils.isBlank(urlInit)) {
    		return null;
    	}
//        String url = urlInit + "?ticket=" + heads.get("ticket");
        String url = urlInit;
        try {
            HttpPost httpPost = new HttpPost(url);
            if (params != null && !params.isEmpty()) {
            	logger.info("[相关http参数]-"+JsonParse.map2Json(params));
                StringEntity myEntity = new StringEntity(JsonParse.map2Json(params), charset);
                httpPost.setEntity(myEntity);
            }
            if (heads != null) {
                for (Entry<String, String> e : heads.entrySet()) {
                    httpPost.addHeader(e.getKey(), e.getValue());
                }
            }
            CloseableHttpResponse response = httpClient.execute(httpPost);
           HttpEntity entity = response.getEntity();
            String result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, "utf-8");
            }

            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode != 200) {
                logger.info("【URL】-" + url);
                logger.info("[返回结果]-" + result);
                httpPost.abort();
//                throw new RuntimeException("HttpClient,error status code :" + statusCode);
                logger.error("HttpClient,error status code :" + statusCode);
                return result;
            }
            if (!JsonParse.getFromKey("ResultCode", result).equals("0")) {
    			logger.info("[返回结果]-" + result);
    		}

            EntityUtils.consume(entity);
            response.close();

            return result;
        } catch (Exception e) {
            if (e instanceof RequestAbortedException || e instanceof SocketTimeoutException || e instanceof SocketException) {
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                return doPostBody(url, params, heads, charset);
            }
            e.printStackTrace();
        }
        return null;
    }
	
}
