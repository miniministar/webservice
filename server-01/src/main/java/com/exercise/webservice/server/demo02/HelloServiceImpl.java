package com.exercise.webservice.server.demo02;

import java.util.Date;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.apache.cxf.interceptor.InInterceptors;
import org.springframework.stereotype.Component;


@InInterceptors(interceptors={"com.exercise.webservice.server.demo02.HelloAuthInterceptor"})// 添加拦截器
@WebService
@SOAPBinding(style=Style.RPC)
@Component
public class HelloServiceImpl implements IhelloService {

    @Override
    public String helloWebService(String message) {
        System.out.println(message);
        return "响应：" + new Date();
    }

}
