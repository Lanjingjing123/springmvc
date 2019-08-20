package com.csii.ljj.xmlStudy;

import com.csii.ljj.fund.FundRequest;
import org.junit.Test;

import javax.xml.bind.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.util.*;

public class simpleBeanToXmlTest {


    @Test
    public void test1() throws JAXBException {
        Product p = new Product();
        p.setId("1100");
        p.setName("Apple");
        Order order = new Order();
        order.setId("1101");
        order.setPrice(23.45);
        order.setProduct(p);
        JAXBContext context = JAXBContext.newInstance(Order.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(order, System.out);
    }

    @Test
    public void test2() throws JAXBException {

        Product p1 = new Product();
        p1.setId("11021");
        p1.setName("Apple");


        Product p2 = new Product();
        p2.setId("11022");
        p2.setName("Banana");
        List<Product> list = Arrays.asList(p1,p2);
        Order2 order = new Order2();
        order.setId("1102");
        order.setPrice(45.67);
        order.setProduct(list);


        JAXBContext context = JAXBContext.newInstance(Order2.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(order, System.out);
    }


    public  void xmlTojava() throws Exception {
        // 获取JAXB的上下文环境，需要传入具体的 Java bean -> 这里使用Student
        JAXBContext context = JAXBContext.newInstance(FundRequest.class);
        // 创建 UnMarshaller 实例
        Unmarshaller unmarshaller = context.createUnmarshaller();
        // 加载需要转换的XML数据 -> 这里使用InputStream，还可以使用File，Reader等
        InputStream stream = new FileInputStream(new File("E:\\idea_project\\springmvc\\springmvc02\\data\\test.xml"));
//        StringReader sr = new StringReader(xml);
//        Document
        // 将XML数据序列化 -> 该方法的返回值为Object基类，需要强转类型

        FundRequest order2 = (FundRequest) unmarshaller.unmarshal(stream);

        // 将结果打印到控制台
        System.out.println(order2);
    }

    @Test
    public void test3(){
        String xml = "";
        try {
            xmlTojava();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
