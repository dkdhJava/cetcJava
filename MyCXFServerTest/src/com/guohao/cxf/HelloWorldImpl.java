package com.guohao.cxf;

public class HelloWorldImpl implements IHelloWorld {
	public String hello(String name) {
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
		System.out.println("a");
		return "hello," + name;
	}

}
