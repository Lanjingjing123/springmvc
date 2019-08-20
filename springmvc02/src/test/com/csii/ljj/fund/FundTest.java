package com.csii.ljj.fund;


import com.csii.ljj.fund.request.Request;
import com.csii.ljj.fund.request.newRequest;
import com.csii.ljj.xmlStudy.Order2;
import org.junit.Test;
import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.beans.Encoder;
import java.io.*;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class FundTest {

    @Test
    public void test2() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        // 创建头部信息
        FundRequestHead head = new FundRequestHead();
        head.setTxCode("1610");

        // 创建body信息
        FundRequestBody body = new FundRequestBody();
        body.setBatchNo(1);
        body.setInstitutionID("0098");
        body.setRemark("测试");
        body.setTotalAmount(new BigDecimal(200000.03).setScale(2, BigDecimal.ROUND_DOWN));
        body.setTotalCount(3);

        List<RepayInfo> infos = new LinkedList<>();
        RepayInfo repayInfo = new RepayInfo();
        repayInfo.setItemNo("1234567890");
        repayInfo.setAccountNumber("0098012345");
        repayInfo.setAccountName("兰晶晶");
        repayInfo.setAccountType("10");
        // 第一个节点
        infos.add(repayInfo);

        repayInfo = new RepayInfo();
        repayInfo.setItemNo("987654321");
        repayInfo.setAccountNumber("0098000000");
        repayInfo.setAccountName("高祥康");
        repayInfo.setAccountType("10");
        // 第二个节点
        infos.add(repayInfo);

        body.setRepayInfos(infos);
        // 合并head和body 生成request信息
        Request request = new newRequest();
        ((newRequest) request).setBody(body);
        request.setRequestHead(head);

        // 合并head和body 生成request信息
        request = new newRequest();
        ((newRequest) request).setBody(body);
        request.setRequestHead(head);

        // beanTOxml
        StringWriter sw = null;
        try {
            sw = beanToXml(request);
        } catch (JAXBException e) {

            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(sw);

        // xmlTObean
        Request request1 = new newRequest();
        try {
            request1 = xmlToBean(sw.toString(), request1);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test1() throws IllegalAccessException, InstantiationException, ClassNotFoundException, FileNotFoundException {
        // 创建头部信息
        FundRequestHead head = new FundRequestHead();
        head.setTxCode("1610");

        // 创建body信息
        FundRequestBody body = new FundRequestBody();
        body.setBatchNo(1);
        body.setInstitutionID("0098");
        body.setRemark("测试");
        body.setTotalAmount(new BigDecimal(200000.03).setScale(2,BigDecimal.ROUND_DOWN));
        body.setTotalCount(3);

        List<RepayInfo> infos = new LinkedList<>();
        RepayInfo repayInfo = new RepayInfo();
        repayInfo.setItemNo("1234567890");
        repayInfo.setAccountNumber("0098012345");
        repayInfo.setAccountName("兰晶晶");
        repayInfo.setAccountType("10");
        // 第一个节点
        infos.add(repayInfo);

        repayInfo = new  RepayInfo();
        repayInfo.setItemNo("987654321");
        repayInfo.setAccountNumber("0098000000");
        repayInfo.setAccountName("高祥康");
        repayInfo.setAccountType("10");
        // 第二个节点
        infos.add(repayInfo);

        body.setRepayInfos(infos);
        // 合并head和body 生成request信息
        FundRequest request = new FundRequest();
        request.setRequestBody(body);
        request.setRequestHead(head);

        // beanTOxml
        StringWriter sw = null;
        try {
            sw = beanToXml(request);
        } catch (JAXBException e) {

            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(sw);

        // xmlTObean
        FundRequest request1 = new FundRequest();
        try {
            request1 = xmlToBean(sw.toString(),request1);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        System.out.println("requestHead: "+request1.getRequestHead()+"txtCode"+request1.getRequestHead().getTxCode()+"\n"+"requestBody: "+request1.getRequestBody());

    }


    /**
     * XML转换为javabean
     * Jul 25, 2013 9:39:05 PM xuejiangtao添加此方法
     * @param <T>
     * @param xml
     * @param t 想转换的bean
     * @return
     * @throws JAXBException
     */
    private static <T> T xmlToBean(String xml, T t) throws JAXBException, ClassNotFoundException, IllegalAccessException, InstantiationException {


        JAXBContext context = JAXBContext.newInstance(t.getClass());
        Unmarshaller um = context.createUnmarshaller();
        StringReader sr = new StringReader(xml);
        t = (T) um.unmarshal(sr);
        return t;
    }

    /**
     * javabean转换为XML
     * Jul 25, 2013 9:39:09 PM xuejiangtao添加此方法
     * @param
     * @return
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    private static <T> StringWriter beanToXml(T t) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(t.getClass());
        Marshaller m = context.createMarshaller();
        StringWriter sw = new StringWriter();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);//是否格式化
        m.setProperty(Marshaller.JAXB_ENCODING,"UTF-8");

        m.marshal(t, sw);
        m.marshal(t, new FileOutputStream("E:\\idea_project\\springmvc\\springmvc02\\data\\test.xml"));
        return sw;
    }




}
