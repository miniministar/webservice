package com.exercise.webservice.client.demo02;

import com.exercise.webservice.client.demo02.gen.cxf.IhelloService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class WebServiceFactory {
    public static void main(String[] args) {
        IhelloService service = getHelloWorldService();
        String result = service.helloWebService("张三");
        System.out.println(result);
    }
    public static IhelloService getHelloWorldService() {
        Map<String, Object> outProps = new HashMap<String, Object>();
        outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
        outProps.put(WSHandlerConstants.USER, "admin");//这个用户即服务器端配置的用户名
        outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_DIGEST);
        outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, ClientPasswordCallbackHandler.class.getName());//这个类用来获取客户端认证用户名密码信息
        JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
        bean.getInInterceptors().add(new LoggingInInterceptor());
        bean.getInFaultInterceptors().add(new LoggingOutInterceptor());
        bean.setServiceClass(IhelloService.class);
        bean.setAddress(Constants.wsdlURL);
        IhelloService helloWorldService = (IhelloService) bean.create();
        ClientProxy clientProxy = (ClientProxy) Proxy.getInvocationHandler(helloWorldService);
        Client client = clientProxy.getClient();
        client.getOutInterceptors().add(new WSS4JOutInterceptor(outProps));//配置拦截器
        return helloWorldService;
    }
}