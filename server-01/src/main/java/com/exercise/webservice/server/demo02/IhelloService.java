package com.exercise.webservice.server.demo02;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @desc: 测试发布的websercice服务
 */
@WebService
public interface IhelloService {
    
    /**
     * @desc: 测试发布的websercice接口
     * @author: wzh
     * @date: 2019年3月31日
     * @param message
     * @return
     */
    @WebMethod
    public String helloWebService(@WebParam(name="msg")String message);

}
