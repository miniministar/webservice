
package com.exercise.webservice.client.demo01.gen;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.exercise.webservice.client.demo01.gen package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _HelloWord3Response_QNAME = new QName("http://demo01.server.webservice.exercise.com/", "HelloWord3Response");
    private final static QName _HelloWordResponse_QNAME = new QName("http://demo01.server.webservice.exercise.com/", "HelloWordResponse");
    private final static QName _HelloWord3_QNAME = new QName("http://demo01.server.webservice.exercise.com/", "HelloWord3");
    private final static QName _HelloWord_QNAME = new QName("http://demo01.server.webservice.exercise.com/", "HelloWord");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.exercise.webservice.client.demo01.gen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HelloWord3Response }
     * 
     */
    public HelloWord3Response createHelloWord3Response() {
        return new HelloWord3Response();
    }

    /**
     * Create an instance of {@link HelloWordResponse }
     * 
     */
    public HelloWordResponse createHelloWordResponse() {
        return new HelloWordResponse();
    }

    /**
     * Create an instance of {@link HelloWord3 }
     * 
     */
    public HelloWord3 createHelloWord3() {
        return new HelloWord3();
    }

    /**
     * Create an instance of {@link HelloWord }
     * 
     */
    public HelloWord createHelloWord() {
        return new HelloWord();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloWord3Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://demo01.server.webservice.exercise.com/", name = "HelloWord3Response")
    public JAXBElement<HelloWord3Response> createHelloWord3Response(HelloWord3Response value) {
        return new JAXBElement<HelloWord3Response>(_HelloWord3Response_QNAME, HelloWord3Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloWordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://demo01.server.webservice.exercise.com/", name = "HelloWordResponse")
    public JAXBElement<HelloWordResponse> createHelloWordResponse(HelloWordResponse value) {
        return new JAXBElement<HelloWordResponse>(_HelloWordResponse_QNAME, HelloWordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloWord3 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://demo01.server.webservice.exercise.com/", name = "HelloWord3")
    public JAXBElement<HelloWord3> createHelloWord3(HelloWord3 value) {
        return new JAXBElement<HelloWord3>(_HelloWord3_QNAME, HelloWord3 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloWord }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://demo01.server.webservice.exercise.com/", name = "HelloWord")
    public JAXBElement<HelloWord> createHelloWord(HelloWord value) {
        return new JAXBElement<HelloWord>(_HelloWord_QNAME, HelloWord.class, null, value);
    }

}
