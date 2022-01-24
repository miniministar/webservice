package com.exercise.webservice.client.demo01;

import com.exercise.webservice.client.demo01.gen.HelloWebService;
import com.exercise.webservice.client.demo01.gen.HelloWebServiceService;

public class WsImportClient {

    public static void main(String[] args) {
        HelloWebServiceService hwss = new HelloWebServiceService();
        HelloWebService hws = hwss.getHelloWebServicePort();
        String result = hws.helloWord("张三");
        System.out.println(result);
        String result2 = hws.helloWord3("abc");
        System.out.println(result2);
    }

}