package org.com.tools.httptool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * HttpClient4.3工具类
 * @author hang.luo
 */
public class HttpClientUtils
{
    private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class); // 日志记录

    private static RequestConfig requestConfig = null;
    
    /**
     * 连接超时时间
     */
    private static int CONNECT_TIMEOUT = 5000;

    /**
     * 请求超时时间
     */
    private static int CONNECTION_REQUEST_TIMEOUT = 5000;

    /**
     * socket超时时间
     */
    private static int SOCKET_TIMEOUT = 5000;

    /**
     * 是否允许自动重定向
     */
    private static boolean REDIRECTS_ENABLED = true;

    static
    {
        // 设置请求和传输超时时间
        requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
    }

    /**
     * post请求传输json参数
     * @param url  url地址
     * @param json 参数
     * @return
     */
    public static JSONObject httpPost(String url, JSONObject jsonParam)
    {
        // post请求返回结果
        CloseableHttpClient httpClient = HttpClients.createDefault();
        JSONObject jsonResult = null;
        HttpPost httpPost = new HttpPost(url);
        // 设置请求和传输超时时间
        httpPost.setConfig(requestConfig);
        try
        {
            if (null != jsonParam)
            {
                // 解决中文乱码问题
                StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                httpPost.setEntity(entity);
            }
            CloseableHttpResponse result = httpClient.execute(httpPost);
            // 请求发送成功，并得到响应
            if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
            {
                String str = "";
                try
                {
                    // 读取服务器返回过来的json字符串数据
                    str = EntityUtils.toString(result.getEntity(), "utf-8");
                    // 把json字符串转换成json对象
                    jsonResult = JSONObject.parseObject(str);
                }
                catch (Exception e)
                {
                    logger.error("post请求提交失败:" + url, e);
                }
            }
        }
        catch (IOException e)
        {
            logger.error("post请求提交失败:" + url, e);
        }
        finally
        {
            httpPost.releaseConnection();
        }
        return jsonResult;
    }

    /**
     * post请求传输String参数 例如：name=Jack&sex=1&type=2
     * Content-type:application/x-www-form-urlencoded
     * @param url            url地址
     * @param strParam       参数
     * @return
     */
    public static JSONObject httpPost(String url, String strParam)
    {
        // post请求返回结果
        CloseableHttpClient httpClient = HttpClients.createDefault();
        JSONObject jsonResult = null;
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        try
        {
            if (null != strParam)
            {
                // 解决中文乱码问题
                StringEntity entity = new StringEntity(strParam, "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/x-www-form-urlencoded");
                httpPost.setEntity(entity);
            }
            CloseableHttpResponse result = httpClient.execute(httpPost);
            // 请求发送成功，并得到响应
            if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
            {
                String str = "";
                try
                {
                    // 读取服务器返回过来的json字符串数据
                    str = EntityUtils.toString(result.getEntity(), "utf-8");
                    // 把json字符串转换成json对象
                    jsonResult = JSONObject.parseObject(str);
                }
                catch (Exception e)
                {
                    logger.error("post请求提交失败:" + url, e);
                }
            }
        }
        catch (IOException e)
        {
            logger.error("post请求提交失败:" + url, e);
        }
        finally
        {
            httpPost.releaseConnection();
        }
        return jsonResult;
    }

    /**
     * 发送get请求
     * @param url 路径
     * @return
     */
    public static JSONObject httpGet(String url)
    {
        // get请求返回结果
        JSONObject jsonResult = null;
        CloseableHttpClient client = HttpClients.createDefault();
        // 发送get请求
        HttpGet request = new HttpGet(url);
        request.setConfig(requestConfig);
        try
        {
            CloseableHttpResponse response = client.execute(request);

            // 请求发送成功，并得到响应
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
            {
                // 读取服务器返回过来的json字符串数据
                HttpEntity entity = response.getEntity();
                String strResult = EntityUtils.toString(entity, "utf-8");
                // 把json字符串转换成json对象
                jsonResult = JSONObject.parseObject(strResult);
            }
            else
            {
                logger.error("get请求提交失败:" + url);
            }
        }
        catch (IOException e)
        {
            logger.error("get请求提交失败:" + url, e);
        }
        finally
        {
            request.releaseConnection();
        }
        return jsonResult;
    }
    
    /**
     * 发送get请求
     * @param url 请求路径
     * @return 响应数据或null
     */
    public static Map<String, Object> doGet(String url) {
        CloseableHttpClient httpCilent = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(CONNECT_TIMEOUT)
                .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .setRedirectsEnabled(REDIRECTS_ENABLED)
                .build();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);
        try {
            HttpResponse httpResponse = httpCilent.execute(httpGet);
            String result = EntityUtils.toString(httpResponse.getEntity());//获得返回的结果
            return (Map<String, Object>)JSON.parseObject(result);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return null;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        } finally {
            if (httpCilent != null) {
                try {
                    httpCilent.close();
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
    }

    /**
     * 发送post请求
     * @param url 请求路径
     * @param params 请求参数Map
     * @return 响应数据或null
     */
    public static Map<String, Object> doPost(String url, Map<String, Object> params){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(CONNECT_TIMEOUT)
                .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .setRedirectsEnabled(REDIRECTS_ENABLED)
                .build();
        httpPost.setConfig(requestConfig);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        for (String key : params.keySet()) {
            nvps.addAll((Collection<? extends NameValuePair>) new BasicNameValuePair(key, String.valueOf(params.get(key))));
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity((List<? extends org.apache.http.NameValuePair>) nvps, "UTF-8"));
            logger.info("httpPost: " + EntityUtils.toString(httpPost.getEntity()));
            HttpResponse response = httpClient.execute(httpPost);
            String result = EntityUtils.toString(response.getEntity());
            return (Map<String, Object>)JSON.parseObject(result);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return null;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
    }

    /**
     * 发送post请求
     * @param url 请求路径
     * @param jsonParams json格式请求参数
     * @return 响应数据或null
     */
    public static Map<String, Object> doPost(String url, String jsonParams){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(CONNECT_TIMEOUT)
                .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .setRedirectsEnabled(REDIRECTS_ENABLED)
                .build();

        httpPost.setConfig(requestConfig);
        httpPost.setHeader("Content-Type", "application/json");
        try {
            httpPost.setEntity(new StringEntity(jsonParams, ContentType.create("application/json", "utf-8")));
            logger.info("request parameters: " + EntityUtils.toString(httpPost.getEntity()));
            HttpResponse response = httpClient.execute(httpPost);
            String result = EntityUtils.toString(response.getEntity());
            return (Map<String, Object>)JSON.parseObject(result);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return null;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
    }

    public static boolean isSuccess() {
        return false;
    }

	public static Map<String, Object> doGetFile(HttpServletRequest request, String sourceUrl) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
