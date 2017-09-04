package beanfactory;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by robin on 2017/8/21.
 */
public class IOCApplicationContext implements BeanFactory{
    private String configFileName=null;
    //bean容器  ： <beanID,bean对象>
    private Map<String, Object> beans = new HashMap<String, Object>();
    public IOCApplicationContext(String configFileName){
        this.configFileName=configFileName;
        loadXMLAndCreateBeans();
    }
    private void loadXMLAndCreateBeans()  {
        try {
            SAXBuilder sb = new SAXBuilder();
            Document document = sb.build(this.getClass().getClassLoader().getResourceAsStream("beans.xml"));
            Element rootElement=document.getRootElement();
            List<Element> list=rootElement.getChildren();
            for(Element element:list){
                String beanID=element.getAttributeValue("id");
                String clazz=element.getAttributeValue("class");
                System.out.println("bean+clazz:"+beanID+"---"+clazz);
                Class c=Class.forName(clazz);
                System.out.println("class type :"+c.getName());
                Object object=c.newInstance();
                System.out.println("put beans :"+beanID+"===="+object);
                beans.put(beanID,object);
                for(Element property:(List<Element>)element.getChildren()){
                    String propertyName=property.getAttributeValue("name");
                    String propertyRef=property.getAttributeValue("ref");
                    String propertyValue=property.getAttributeValue("value");
                    if(propertyRef!=null) {
                        Object attrObj = beans.get(propertyName);
                        //由属性name拼接得到方法setName()
                        String setBean = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
                        System.out.println("setbean===:" + setBean);
                        System.out.println("attrobj===:" + attrObj);
                        System.out.println("----" + setBean + "---" + propertyRef);
                        Method method = object.getClass().getDeclaredMethod(setBean, beans.get(propertyRef).getClass().getInterfaces()[0]);
                        method.invoke(object, attrObj);
                    }else{
                        //由属性name拼接得到方法setName()
                        String setBean = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
                        System.out.println("setbean===:" + setBean);
                        System.out.println("----" + setBean + "---" + propertyRef);
                        Method method = object.getClass().getDeclaredMethod(setBean,String.class);
                        method.invoke(object, propertyValue);
                    }
                }
            }

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String name) {
        return beans.get(name);
    }
}


