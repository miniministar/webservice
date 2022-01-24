
package com.exercise.webservice.client.demo02.gen.cxf;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.5.0
 * 2022-01-22T20:47:25.854+08:00
 * Generated source version: 3.5.0
 *
 */
public final class IhelloService_HelloServiceImplPort_Client {

    private static final QName SERVICE_NAME = new QName("http://demo02.server.webservice.exercise.com/", "HelloServiceImplService");

    private IhelloService_HelloServiceImplPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = HelloServiceImplService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        HelloServiceImplService ss = new HelloServiceImplService(wsdlURL, SERVICE_NAME);
        IhelloService port = ss.getHelloServiceImplPort();

        {
        System.out.println("Invoking helloWebService...");
        java.lang.String _helloWebService_msg = "";
        java.lang.String _helloWebService__return = port.helloWebService(_helloWebService_msg);
        System.out.println("helloWebService.result=" + _helloWebService__return);


        }

        System.exit(0);
    }

}