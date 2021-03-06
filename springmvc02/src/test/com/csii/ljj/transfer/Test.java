package com.csii.ljj.transfer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Test {

    /**
     * XML转换为javabean
     * Jul 25, 2013 9:39:05 PM xuejiangtao添加此方法
     * @param <T>
     * @param xml
     * @param t
     * @return
     * @throws JAXBException
     */
    public static <T> T xmlToBean(String xml, T t) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(t.getClass());
        Unmarshaller um = context.createUnmarshaller();
        StringReader sr = new StringReader(xml);
        t = (T) um.unmarshal(sr);
        return t;
    }

    /**
     * javabean转换为XML
     * Jul 25, 2013 9:39:09 PM xuejiangtao添加此方法
     * @param smsDeliverReq
     * @return
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    public static <T> StringWriter beanToXml(T t) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(t.getClass());
        Marshaller m = context.createMarshaller();
        StringWriter sw = new StringWriter();
        m.marshal(t, sw);
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);//是否格式化
        m.marshal(t, new FileOutputStream("E:\\idea_project\\springmvc\\springmvc02\\data\\test.xml"));
        return sw;
    }

    /**
     * Jul 24, 2013 10:12:39 PM xuejiangtao添加此方法
     * @param args
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        ReqHeader reqHeader = new ReqHeader();
        reqHeader.setReqNo("111");
        reqHeader.setAuthCode("DDDD");
        reqHeader.setSysId("jjj");

        SmsBody smsBody = new SmsBody();
        // 新增一个List
        List<LnIouNoInfo> lnIouNoInfos = new LinkedList<>();
        LnIouNoInfo lnIouNoInfo = new LnIouNoInfo("ljj3006",new BigDecimal(100.23).setScale(2,BigDecimal.ROUND_DOWN),new BigDecimal(200.33).setScale(2,BigDecimal.ROUND_DOWN));
        lnIouNoInfos.add(lnIouNoInfo);

        smsBody.setContent("类容讷讷");
        smsBody.setDestAddr("1589594");
        smsBody.setSourceAddr("9999");
        smsBody.setLnIouNoInfoList(lnIouNoInfos);

        SmsBody smsBody1 = new SmsBody();
        smsBody1.setContent("asdf");
        smsBody1.setDestAddr("asdf");
        smsBody1.setSourceAddr("4fdf");


        SmsDeliverReq smsDeliverReq = new SmsDeliverReq();
        smsDeliverReq.setReqHeader(reqHeader);
        List<SmsBody> smsBodys = new ArrayList<SmsBody>();
        smsBodys.add(smsBody);
        smsBodys.add(smsBody1);
        smsDeliverReq.setSmsBodys(smsBodys);

        StringWriter sw = beanToXml(smsDeliverReq);
        System.out.println(sw.toString());

        SmsDeliverReq xmlToBean = xmlToBean(sw.toString(), smsDeliverReq);
        System.out.println(xmlToBean.toString());
    }
}