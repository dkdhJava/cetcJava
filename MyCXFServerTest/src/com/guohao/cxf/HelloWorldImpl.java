package com.guohao.cxf;

public class HelloWorldImpl implements IHelloWorld {
	public String hello(String name) {
		System.out.println("hello," + name);
		System.out.println("hello," + name);
		System.out.println("hello," + name);
		return "hello," + name;
	}

}
