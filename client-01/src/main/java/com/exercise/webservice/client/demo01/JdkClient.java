package com.exercise.webservice.client.demo01;

import com.exercise.webservice.client.demo01.gen.HelloWebService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class JdkClient {

    public static void main(String[] args) throws MalformedURLException {
        String wsdlURL = "http://localhost:8123/helloWord?wsdl";
        String namespaceURI = "http://demo01.server.webservice.exercise.com/";
        String serviceName = "HelloWebServiceService";
        String localPart = "HelloWebServicePort";
        URL url = new URL(wsdlURL);
        // 指定命名空间和服务名称
        QName qName = new QName(namespaceURI, serviceName);
        Service service = Service.create(url, qName);
//        // 通过getPort方法返回指定接口
//        QName portName = new QName(namespaceURI, localPart);
//        HelloWebService port = service.getPort(portName, HelloWebService.class);
        HelloWebService port = service.getPort(HelloWebService.class);
        // 调用方法 获取返回值
        String result = port.helloWord("张三");
        System.out.println(result);
    }
}
