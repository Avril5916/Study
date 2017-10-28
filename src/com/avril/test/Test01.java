package com.avril.test;

import com.avril.domain.Users;
import com.avril.ioc.MyIOCContainer;
/**
 * 测试ioc
 * @author Avril
 *
 */
public class Test01 {

	public static void main(String[] args) {
		
		MyIOCContainer ioc = new MyIOCContainer();
		Users u = (Users) ioc.dependenceInjection("Users");
		u.setUserid(1L);
		System.out.println(u.getUserid());
	}
}
