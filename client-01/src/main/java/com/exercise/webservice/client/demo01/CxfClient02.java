package com.exercise.webservice.client.demo01;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class CxfClient02 {
    public static void main(String[] args) throws Exception {
        //采用动态工厂方式 不需要指定服务接口
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(Constants.wsdlURL);
        Object[] result = client.invoke("HelloWord", new Object[] { "张三" });
        System.out.println(result[0]);
    }
}
