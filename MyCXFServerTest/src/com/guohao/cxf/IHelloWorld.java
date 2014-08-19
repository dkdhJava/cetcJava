package com.guohao.cxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface IHelloWorld {
	@WebMethod
	public @WebResult String hello(@WebParam String name);
}
