package com.csii.ljj.xmlStudy;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.io.PrintStream;

public class TestJava2Xml {
    public static void main(String[] args) {
        Student stu = new Student("001","Tom",22);
        try {
            javaToxml(stu);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void javaToxml(Student stu) throws JAXBException {
        // 获取JAXB的上下文环境，需要传入具体的 Java bean -> 这里使用Student
        JAXBContext context = JAXBContext.newInstance(Student.class);
        // 创建 Marshaller 实例
        Marshaller marshaller = context.createMarshaller();
        // 设置转换参数 -> 这里举例是告诉序列化器是否格式化输出
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // 构建输出环境 -> 这里使用标准输出，输出到控制台Console
        PrintStream out = System.out;
        // 将所需对象序列化 -> 该方法没有返回值
        marshaller.marshal(stu, out);
    }

    public static void xmlTojava(InputStream inputStream) throws Exception {
        // 获取JAXB的上下文环境，需要传入具体的 Java bean -> 这里使用Student
        JAXBContext context = JAXBContext.newInstance(Student.class);
        // 创建 UnMarshaller 实例
        Unmarshaller unmarshaller = context.createUnmarshaller();
        // 加载需要转换的XML数据 -> 这里使用InputStream，还可以使用File，Reader等
        InputStream stream = inputStream;
        // 将XML数据序列化 -> 该方法的返回值为Object基类，需要强转类型
        Student stu = (Student) unmarshaller.unmarshal(stream);
        // 将结果打印到控制台
        System.out.println(stu);
    }


}
