package com.exercise.webservice.client.demo02;


import com.exercise.webservice.client.demo02.gen.wsimport.HelloServiceImplService;
import com.exercise.webservice.client.demo02.gen.wsimport.IhelloService;

import javax.xml.ws.BindingProvider;

public class WsImportClient {

    public static void main(String[] args) {
        HelloServiceImplService hwss = new HelloServiceImplService();
        IhelloService hws = hwss.getHelloServiceImplPort();
        // 添加basic 认证
        BindingProvider bp = (BindingProvider) hws;
        bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
        bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "123456");
        String result = hws.helloWebService("张三");
        System.out.println(result);
    }

}