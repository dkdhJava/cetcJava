package com.guohao.cxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface HelloWorld {
	@WebMethod
	public void hello(@WebParam String name);
}
