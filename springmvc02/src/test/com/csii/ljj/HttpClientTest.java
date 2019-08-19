package com.csii.ljj;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;



import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;

public class HttpClientTest {
    public static void main(String[] args) {
        System.out.println("====================开始调用========================");
        String url = "http://localhost:8020/testJson";
        sendPost(url);
    }

    /**
     *
     * @param value 对象
     * @return
     */
//    public  static String objectToXml(Object value) {
//        String str = null;
//        JAXBContext context = null;
//        StringWriter writer = null;
//        try {
//            context = JAXBContext.newInstance(value.getClass());
//            Marshaller mar = context.createMarshaller();
//            writer = new StringWriter();
//            mar.marshal(value, writer);
//            str = writer.toString().replace("getProductRequest", "GetProductRequest");
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        } finally {
//            if (context != null) context = null;
//            if (writer != null) {
//                try {
//                    writer.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                writer = null;
//            }
//        }
//
//        return str;
//
//    }



    /**
     * 发送xml请求到server端
     * @param url xml请求数据地址
     * @return null发送失败，否则返回响应内容
     */
    public static void sendPost(String url) {


        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // 创建Post请求
        HttpPost httpPost = new HttpPost(url);

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();

            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
