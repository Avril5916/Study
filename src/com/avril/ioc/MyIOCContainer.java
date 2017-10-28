package com.avril.ioc;

import java.util.HashMap;
import java.util.Map;

import com.avril.domain.StarCraft;

public class MyIOCContainer {
	private Map<String,String> beanMap = new HashMap<>();
	
	

	//依赖注入，暂时只使用setter注入，未设置单例
	public  Object dependenceInjection(String classname){
		//暂时使用static块模拟从xml中读取bean的配置并放入map中（Spring中使用的是ConCurrentMap）
		beanMap.put("StarCraft", "com.avril.domain.StarCraft");
		beanMap.put("WarCraft", "com.avril.domain.WarCraft");
		beanMap.put("Users", "com.avril.domain.Users");
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
