package com.exercise.webservice.client.demo02;

import com.exercise.webservice.client.demo01.gen.HelloWebService;
import com.exercise.webservice.client.demo02.gen.wsimport.HelloServiceImplService;
import com.exercise.webservice.client.demo02.gen.wsimport.IhelloService;
import org.apache.cxf.binding.soap.Soap11;
import org.apache.cxf.binding.soap.SoapBindingConfiguration;
import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import javax.xml.ws.BindingProvider;
import java.util.HashMap;
import java.util.Map;

public class CxfClient {
    public static void main(String[] args) {
//        ServerFactoryBean factory = new ServerFactoryBean();
//        Server server = factory.create();
//        Endpoint cxfEndpoint = server.getEndpoint();
//
//        Map<String,Object> inProps = new HashMap<String,Object>();
//        // how to configure the properties is outlined below;
//
//        WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);
//        cxfEndpoint.getInInterceptors().add(wssIn);
//
//        //WS-Security输出拦截器
//        Map<String,Object> outProps = new HashMap<String,Object>();
//        // how to configure the properties is outlined below;
//        outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
//        //添加用户名
//        outProps.put(WSHandlerConstants.USER, Constants.username);
//        //Password type : plain text
//        outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
//        // for hashed password use:
//        //properties.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_DIGEST);
//        // Callback used to retrieve password for given user.
//        outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, ClientPasswordCallbackHandler.class.getName());
//
//        WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
//        cxfEndpoint.getOutInterceptors().add(wssOut);
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(HelloWebService.class);
        factory.setAddress(Constants.wsdlURL);

//        getServiceProxy(factory, Constants.serviceName);

//        IhelloService service = factory.create(IhelloService.class);
//        String result = service.helloWebService("张三");
//        System.out.println(result);
    }

    public static JaxWsProxyFactoryBean getServiceProxy(BindingProvider servicePort, String serviceAddr) {
        JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
        if(serviceAddr != null)
            proxyFactory.setAddress(serviceAddr);
        proxyFactory.setServiceClass(servicePort.getClass());
        proxyFactory.getOutInterceptors().add(new LoggingOutInterceptor());
        SoapBindingConfiguration config = new SoapBindingConfiguration();
        config.setVersion(Soap11.getInstance());
        proxyFactory.setBindingConfig(config);
        Client deviceClient = ClientProxy.getClient(servicePort);

        HTTPConduit http = (HTTPConduit) deviceClient.getConduit();

		AuthorizationPolicy authPolicy = new AuthorizationPolicy();
		authPolicy.setUserName(Constants.username);
		authPolicy.setPassword(Constants.password);
		authPolicy.setAuthorizationType("Basic");
		http.setAuthorization(authPolicy);

        HTTPClientPolicy httpClientPolicy = http.getClient();
        httpClientPolicy.setConnectionTimeout(36000);
        httpClientPolicy.setReceiveTimeout(32000);
        httpClientPolicy.setAllowChunking(false);
        return proxyFactory;
    }

}
