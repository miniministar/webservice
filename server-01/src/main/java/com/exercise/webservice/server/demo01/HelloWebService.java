package com.exercise.webservice.server.demo01;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * @WebService－它是一个注解，用在类上指定将此类发布成一个ws.
 * Endpoint–此类为端点服务类，它的方法publish用于将一个已经添加了@WebService注解对象绑定到一个地址的端口上。
 * @authorxuemin
 */
@WebService
public class HelloWebService {

    public String HelloWord(String name) {
        return "Hello:" + name;
    }

    /**
     * 添加exclude=true后，HelloWord2()方法不会被发布
     *
     * @return
     * @paramname
     */
    @WebMethod(exclude = true)
    public String HelloWord2(String name) {
        return "Hello:" + name;
    }

    public String HelloWord3(String name) {
        return "Hello:" + name;
    }

    public static void main(String[] args) {
        /**
         *参数1：服务的发布地址,这个地址就是提供给外界访问Webervice的URL地址,可以改成服务器ip或域名
         *参数2：服务的实现者
         *服务地址：http://localhost:8123/helloWord?wsdl，只要在客户端浏览器能看到此WSDL文档，说明服务发布成功
         */
        Endpoint.publish("http://localhost:8123/helloWord", new HelloWebService());
    }
}