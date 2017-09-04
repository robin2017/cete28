package beanfactory;

/**
 * Created by robin on 2017/8/21.
 */


import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ApplicationContext_teacher {//Spring context
    /**存储xml的配置信息*/
    private Map<String,String> xmlBeanMap=
            new HashMap<String,String>();
    /**存储bean对象*/
    private Map<String,Object> objBeanMap=
            new HashMap<String,Object>();

    public ApplicationContext_teacher(String configFile) throws Exception{
        loadXml(configFile);
    }
    public void loadXml(String configFile) throws Exception{
        //1.解析xml(借助标准DOM解析)
        DocumentBuilder builder=
                DocumentBuilderFactory
                        .newInstance().newDocumentBuilder();
        InputStream in=
                ApplicationContext_teacher.class.getClassLoader().getResourceAsStream(configFile);
        Document doc=builder.parse(in);
        //2.存储解析的数据
        Element root=doc.getDocumentElement();
        NodeList beans=root.getElementsByTagName("bean");
        for(int i=0;i<beans.getLength();i++) {
            Node node=beans.item(i);
            NamedNodeMap maps=
                    node.getAttributes();
            Node id=maps.getNamedItem("id");
            Node clazz=maps.getNamedItem("class");
            xmlBeanMap.put(id.getNodeValue(),clazz.getNodeValue());
        }
        //System.out.println(xmlBeanMap);
        FileInputStream inputStream;

    }
    public Object getBean(String beanName) {
        Object obj=objBeanMap.get(beanName);
        if(obj!=null)return obj;
        String className=xmlBeanMap.get(beanName);
        if(className==null)
            throw new RuntimeException("bean没有找到");
        try {
            Class<?> clazz=Class.forName(className);
            Object instance=clazz.newInstance();
            objBeanMap.put(beanName, instance);
            return instance;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
