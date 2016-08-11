package com.wgmf.temporyjob.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopDemo {
	 
	public static void main(String[] args) {
		ClassPathXmlApplicationContext xmlCtx = new ClassPathXmlApplicationContext("conf/spring.xml");
		AopController apoController =(AopController) xmlCtx.getBean("aopController");
		System.out.println("×îÖÕ½á¹û£º"+apoController.domywork("me"));
	}
}
