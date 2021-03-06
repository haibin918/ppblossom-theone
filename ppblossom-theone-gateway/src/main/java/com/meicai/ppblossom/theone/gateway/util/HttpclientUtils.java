//package com.meicai.ppblossom.theone.gateway.util;
///**
// *
// */
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.http.HttpEntity;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.config.Registry;
//import org.apache.http.config.RegistryBuilder;
//import org.apache.http.conn.socket.ConnectionSocketFactory;
//import org.apache.http.conn.socket.PlainConnectionSocketFactory;
//import org.apache.http.conn.ssl.NoopHostnameVerifier;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.conn.ssl.TrustStrategy;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import org.apache.http.util.EntityUtils;
//
//import javax.net.ssl.SSLContext;
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.security.KeyManagementException;
//import java.security.KeyStoreException;
//import java.security.NoSuchAlgorithmException;
//import java.security.cert.X509Certificate;
//import java.util.concurrent.TimeUnit;
//
//@Slf4j
//public class HttpclientUtils {
////    private static Logger logger = LoggerFactory.getLogger(HttpclientUtils.class);
//
//    public static final int DEFAULT_SOCKET_TIMEOUT = 5000;
//    public static final int DEFAULT_CONNECT_TIMEOUT = 5000;
//    public static final int DEFAULT_CONNECTION_REQUEST_TIMEOUT = 5000;
//    public static final int DEFAULT_SOCKET_PRINT_TIMEOUT = 30000;
//    public static final int DEFAULT_CONNECT_PRINT_TIMEOUT = 30000;
//    public static final int DEFAULT_CONNECTION_PRINT_REQUEST_TIMEOUT = 30000;
//    //    private static final String DEFAULT_AGENT = "MEICAI/PSPMC";
//    private static CloseableHttpClient httpClient;
//
//    static {
//        //https config
//        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
//        SSLContext sslContext = null;
//        try {
//            sslContext = org.apache.http.ssl.SSLContexts.custom()
//                    .loadTrustMaterial(null, acceptingTrustStrategy)
//                    .build();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (KeyManagementException e) {
//            e.printStackTrace();
//        } catch (KeyStoreException e) {
//            e.printStackTrace();
//        }
//
//        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext
//                , null, null, NoopHostnameVerifier.INSTANCE);
//
//        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
//                .register("http", PlainConnectionSocketFactory.getSocketFactory())
//                .register("https", csf)
//                .build();
//
//        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);
//        //???????????????3000
//        connectionManager.setMaxTotal(100);
//        //???????????????400
//        connectionManager.setDefaultMaxPerRoute(100);
//        RequestConfig requestConfig = RequestConfig.custom()
//                .setSocketTimeout(10000)
//                .setConnectTimeout(2000)
//                .setConnectionRequestTimeout(1000)
//                .build();
//
//
//        httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig)
//                .setConnectionManager(connectionManager)
//                .evictExpiredConnections()
//                .evictIdleConnections(30, TimeUnit.SECONDS)
//                .build();
//    }
//
//    public static String postJsonWithTimeOut(String url, String jsonEntity, int timeout) throws IOException {
//        long start = System.currentTimeMillis();
//        //??????Request???????????????????????????url????????????Request????????????addHeader???setEntity???setConfig
//        HttpPost req = new HttpPost(url);
//        //setConfig,????????????,???????????????????????????,??????????????????
//        RequestConfig reqConfig = RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(1000).build();
//        req.setConfig(reqConfig);
//        req.setHeader("Content-Type", "application/json;charset=UTF-8");
//        //setEntity,????????????
//        req.setEntity(new StringEntity(jsonEntity, Charset.forName("UTF-8")));
//        //??????Request??????,CloseableHttpClient???execute???????????????response??????CloseableHttpResponse??????
//        //??????????????????getFirstHeader(String)???getLastHeader(String)???headerIterator???String???????????????Header name?????????????????????getAllHeaders()???getEntity???getStatus???
//        CloseableHttpResponse response = null;
//        try {
//            response = httpClient.execute(req);
//            //???EntityUtils.toString()?????????????????????HttpEntity??????????????????,??????????????????????????????????????????,?????????????????????????????????????????????utf-8????????????
//            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
//            log.info("http {} cost:{},req:{},resp:{}", url, System.currentTimeMillis() - start, jsonEntity, result);
//            return result;
//        } finally {
//            if (response != null) {
//                response.close();
//            }
//        }
//    }
//
//    public static String postJsonWithTimeOutAndToken(String url, int timeout) throws IOException {
//        long start = System.currentTimeMillis();
//        //??????Request???????????????????????????url????????????Request????????????addHeader???setEntity???setConfig
//        HttpPost req = new HttpPost(url);
//        //setConfig,????????????,???????????????????????????,??????????????????
//        RequestConfig reqConfig = RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(1000).build();
//        req.setConfig(reqConfig);
//        req.setHeader("Content-Type", "application/json;charset=UTF-8");
//        req.setHeader("token", "F6F7F04F4D5648818EC7A9097ADD3BB9");
//        //setEntity,????????????
//        //req.setEntity(new StringEntity(jsonEntity, Charset.forName("UTF-8")));
//        //??????Request??????,CloseableHttpClient???execute???????????????response??????CloseableHttpResponse??????
//        //??????????????????getFirstHeader(String)???getLastHeader(String)???headerIterator???String???????????????Header name?????????????????????getAllHeaders()???getEntity???getStatus???
//        CloseableHttpResponse response = null;
//        try {
//            response = httpClient.execute(req);
//            //???EntityUtils.toString()?????????????????????HttpEntity??????????????????,??????????????????????????????????????????,?????????????????????????????????????????????utf-8????????????
//            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
//            log.info("http {} cost:{},req:{},resp:{}", url, System.currentTimeMillis() - start, "", result);
//            return result;
//        } finally {
//            if (response != null) {
//                response.close();
//            }
//        }
//    }
//
//    public static String get(String url) throws IOException {
//        long start = System.currentTimeMillis();
//        String result = "";
//        HttpGet get = new HttpGet(url);
//        CloseableHttpResponse httpResponse = null;
//        httpResponse = httpClient.execute(get);
//        try {
//            HttpEntity entity = httpResponse.getEntity();
//            if (null != entity) {
//                result = EntityUtils.toString(entity);
//            }
//        } finally {
//            httpResponse.close();
//        }
//        log.info("http {} cost:{},resp:{}", url, System.currentTimeMillis() - start, result);
//        return result;
//    }
//
//}
