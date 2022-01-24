package com.exercise.webservice.client.demo01;

import com.exercise.webservice.client.demo01.gen.HelloWebService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class CxfClient {
    public static void main(String[] args) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(HelloWebService.class);
        factory.setAddress(Constants.wsdlURL);
        // 需要服务接口文件
        HelloWebService client = (HelloWebService) factory.create();
        String result = client.helloWord("张三");
        System.out.println(result);
    }
}
