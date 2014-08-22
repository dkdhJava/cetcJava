package com.guohao.cxf;

public class HelloWorldImpl implements IHelloWorld {
	public String hello(String name) {
		System.out.println("hello,1");
		System.out.println("hello,2");
		System.out.println("hello,3");
		System.out.println("hello,a");
		System.out.println("hello,b"); 
		System.out.println("hello,c"); 
		return "hello," + name;
	}

}
