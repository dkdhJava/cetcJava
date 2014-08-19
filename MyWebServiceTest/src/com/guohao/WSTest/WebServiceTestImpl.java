package com.guohao.WSTest;

public class WebServiceTestImpl implements IWebServiceTest {

	public void testHello(String name) {
		System.out.println("*******************************WebService Server:name=" + name);
	}

}
