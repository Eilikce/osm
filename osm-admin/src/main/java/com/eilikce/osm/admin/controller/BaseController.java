package com.eilikce.osm.admin.controller;

import com.eilikce.osm.core.bo.common.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(BaseController.class);

    /**
     * 注入request对象，线程安全
     */
    @Autowired
    protected HttpServletRequest request;
    /**
     * 注入response对象，线程安全
     */
    @Autowired
    protected HttpServletResponse response;

    /**
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */
    protected ResponseData responseData(int code, String msg, Object data) {

        if (data != null) {
            return new ResponseData(code, msg ,data );
        }
        return new ResponseData(code, msg, "");

    }

    /**
     * 返回成功结果
     * @param data
     * @return
     */
    protected ResponseData responseData(Object data) {
        return responseData(0, "success", data);
    }

    /**
     * 返回成功无数据结果
     * @param msg
     * @return
     */
    protected ResponseData responseData(String msg) {
        return responseData(0, msg, "");
    }

}
