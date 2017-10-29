package com.avril.ioc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.avril.domain.StarCraft;

public class MyIOCContainer {
	
	//用于存储从xml中取出的bean信息
	private static Map<String,String> beanMap = new HashMap<>();
	//静态块读xml
	static{
		SAXReader saxreader = new SAXReader();
		try {
			Document doc = saxreader.read("src/com/avril/ApplicationContext.xml");
			Element root = doc.getRootElement();
			MyIOCContainer myIoc = new MyIOCContainer();
			myIoc.getNodes(root);
			
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}
	}


	/*
	 * 遍历xml文件
	 */
	public void getNodes(Element root){
		List<Attribute> attrs = root.attributes();
		String id = null;//bean标签中的id
		String clazz = null;//bean标签中的class
		//遍历标签
		for (Attribute attribute : attrs) {
			//判断如果是标签中的id属性，则给之前定义的id赋值
			if("id".equals(attribute.getName())){
				id = attribute.getValue();
			//与设置id同理的设置class
			}else if("class".equals(attribute.getName())){
				clazz = attribute.getValue();
			}
			//判断若不为空，则放进map
			if(id!=null&&clazz!=null){
				beanMap.put(id, clazz);
			}
		}	
		//遍历子节点
		List<Element> nodes = root.elements();
		for (Element node : nodes) {
			this.getNodes(node);
		}
	}
	
	

	//依赖注入，暂时只使用setter注入，未设置单例
	public  Object dependenceInjection(String classname){
		
		Iterator<Entry<String, String>> it = beanMap.entrySet().iterator();  
        while (it.hasNext()) {  
            Map.Entry<String, String> entry =  it.next();  
            String key = entry.getKey();  
             String value = entry.getValue();  
            System.out.println("key = " + key + "; value = " + value);  
        }  
        
		//取得路径
		String path = beanMap.get(classname);
		Object o = null;
		try {
			o = getObj(path).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			
			e.printStackTrace();
		}
		
		return o;
	}
	
	
	/*
	 * 反射取对象
	 * 参数：classname-类路径
	 */
	public  Class<?> getObj(String classname){
		Class<?> clazz = null ;
		try {
			clazz = Class.forName(classname);
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found!!!!!!!!!!!!!!!!!!!!!!!!");
			//e.printStackTrace();
		}
		return clazz;
	}
	
	
	
	
	
	
	
	
	
	/*
	 * 三种反射取对象方法
	 * （无视这个方法）
	 */
	public static void justATest() throws ClassNotFoundException{
		
		Class<?> c1 = Class.forName("com.avril.ioc.StarCraft");
			System.out.println(c1.getName());
			System.out.println(c1.isInstance(c1));
			System.out.println(c1.getModifiers());

		Class<?> c2 = StarCraft.class;
			System.out.println(c2.getAnnotations());
	
		Class<?> c3 = new StarCraft().getClass();
	}
	
}
