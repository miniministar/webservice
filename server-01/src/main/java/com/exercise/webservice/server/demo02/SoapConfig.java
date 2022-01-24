package com.exercise.webservice.server.demo02;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.cxf.transport.servlet.CXFServlet;


/**
 * @desc: CXF SOAP 接口配置发布
 */
@Configuration
public class SoapConfig {

    @Autowired
    @Qualifier(Bus.DEFAULT_BUS_ID)
    private SpringBus bus;

    @Autowired
    private IhelloService ihelloService;
    
    /**
     * 改变项目中服务名的前缀名
     * 方法被注释后:wsdl访问地址为http://localhost:8080/SpringBootDemo_eclipse/services/ihelloService?wsdl
     * 去掉注释后：wsdl访问地址为http://localhost:8080/SpringBootDemo_eclipse/soap/ihelloService?wsdl
     * @return
     */
    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/soap/*");
    }

    // 发布多个接口 添加多个@Bean endpoint.publish 这里不能一样
    @Bean
    public Endpoint helloEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, ihelloService);
        endpoint.publish("/ihelloService");
        return endpoint;
    }
}
