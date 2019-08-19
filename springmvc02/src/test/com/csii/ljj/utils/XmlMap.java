package com.csii.ljj.utils;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


/**
 *
 * 提供Map<String,Object>转XML，XML转Map<String,Object>
 *
 * @author MOSHUNWEI
 * @since 2018-03-09
 * @version 5.0
 */


public class XmlMap {


    /**
     *
     * 通过Map创建XML,Map可以多层转换
     *
     * @param params
     * @return	String-->XML
     */
    public static String createXmlByMap(String parentName,Map<String, Object> params,boolean isCDATA){
        Document doc = DocumentHelper.createDocument();
        doc.addElement(parentName);
        String xml = iteratorXml(doc.getRootElement(),parentName,params,isCDATA);
        return formatXML(xml);
    }

    /**
     *
     * 通过Map创建XML,Map可以多层转换
     * 可以自定义parent节点
     *
     * @param params Parent
     * @return	String-->XML
     */
    public static String createXmlByMap(String parentName,Map<String, Object> params){
        Document doc = DocumentHelper.createDocument();
        doc.addElement(parentName);
        String xml = iteratorXml(doc.getRootElement(),parentName,params,false);
        return formatXML(xml);
    }

    /**
     *
     * 通过Map创建XML,Map可以多层转
     * 固定节点parent为Document
     *
     * @param params
     * @return	String-->XML
     */
    public static String createXmlByMap(Map<String, Object> params){
        String parentName = "Document";
        Document doc = DocumentHelper.createDocument();
        doc.addElement(parentName);
        String xml = iteratorXml(doc.getRootElement(),parentName,params,false);
        return formatXML(xml);
    }

    /**
     *
     * MapToXml循环遍历创建xml节点
     * 此方法在value中加入CDATA标识符
     *
     * @param element 根节点
     * @param parentName 子节点名字
     * @param params map数据
     * @return String-->Xml
     */

    @SuppressWarnings("unchecked")
    public static String iteratorXml(Element element,String parentName,Map<String,Object> params,boolean isCDATA) {
        Element e = element.addElement(parentName);
        Set<String> set = params.keySet();
        for (Iterator<String> it = set.iterator(); it.hasNext();) {
            String key = (String) it.next();
            if(params.get(key) instanceof Map) {
                iteratorXml(e,key,(Map<String,Object>)params.get(key),isCDATA);
            }else {
                String value = params.get(key)==null?"":params.get(key).toString();
                if(!isCDATA) {
                    e.addElement(key).addText(value);
                }else {
                    e.addElement(key).addCDATA(value);
                }
            }
        }
        return e.asXML();
    }

    /**
     * 格式化xml,显示为容易看的XML格式
     *
     * @param inputXML
     * @return
     */
    public static String formatXML(String inputXML){
        String requestXML = null;
        XMLWriter writer = null;
        Document document = null;
        try {
            SAXReader reader = new SAXReader();
            document = reader.read(new StringReader(inputXML));
            if (document != null) {
                StringWriter stringWriter = new StringWriter();
                OutputFormat format = new OutputFormat("	", true);//格式化，每一级前的空格
                format.setNewLineAfterDeclaration(false);	//xml声明与内容是否添加空行
                format.setSuppressDeclaration(false);		//是否设置xml声明头部
                format.setNewlines(true);		//设置分行
                writer = new XMLWriter(stringWriter, format);
                writer.write(document);
                writer.flush();
                requestXML = stringWriter.getBuffer().toString();
            }
            return requestXML;
        } catch (Exception e1) {
            e1.printStackTrace();
            return null;
        }finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {

                }
            }
        }
    }


    /**
     *
     * 通过XML转换为Map<String,Object>
     *
     * @param xml 为String类型的Xml
     * @return 第一个为Root节点，Root节点之后为Root的元素，如果为多层，可以通过key获取下一层Map
     */
    public static Map<String, Object> createMapByXml(String xml) {
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<String, Object>();
        if (doc == null)
            return map;
        Element rootElement = doc.getRootElement();
        elementTomap(rootElement,map);
        return map;
    }

    /***
     *
     * XmlToMap核心方法，里面有递归调用
     *
     * @param
     * @param
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> elementTomap (Element outele,Map<String,Object> outmap) {
        List<Element> list = outele.elements();
        int size = list.size();
        if(size == 0){
            outmap.put(outele.getName(), outele.getTextTrim());
        }else{
            Map<String, Object> innermap = new HashMap<String, Object>();
            for(Element ele1 : list){
                String eleName = ele1.getName();
                Object obj =  innermap.get(eleName);
                if(obj == null){
                    elementTomap(ele1,innermap);
                }else{
                    if(obj instanceof java.util.Map){
                        List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
                        list1.add((Map<String, Object>) innermap.remove(eleName));
                        elementTomap(ele1,innermap);
                        list1.add((Map<String, Object>) innermap.remove(eleName));
                        innermap.put(eleName, list1);
                    }else{
                        elementTomap(ele1,innermap);
                        ((List<Map<String, Object>>)obj).add(innermap);
                    }
                }
            }
            outmap.put(outele.getName(), innermap);
        }
        return outmap;
    }
    public static void main(String[] args) {
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("Request", "getData");
        Map<String,Object> map = new HashMap<String,Object>();




        map.put("data", "2018-01-01");
        map.put("name", "jack");



        result.put("Data", map);
//        System.out.println(createXmlByMap(result));
//        System.out.println(createXmlByMap("Parent", result));
//        System.out.println(createXmlByMap("Parent", result,true));
        System.out.println(createMapByXml(createXmlByMap(result)));
    }
}
