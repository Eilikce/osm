package com.eilikce.osm.admin.controller;

import com.eilikce.osm.core.bo.common.ResponseData;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseController {

    private static Logger logger = Logger.getLogger(BaseController.class);

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
     * 请求异常处理
     */
    @ExceptionHandler({BindException.class, MissingServletRequestParameterException.class, ShiroException.class, TypeMismatchException.class})
    protected ResponseData responseException(Exception e) {
        if (e instanceof BindException) {
            logger.error("参数绑定异常",e);
            return responseData(2, "参数绑定异常", e.getMessage());
        } else if (e instanceof AuthenticationException) {
            logger.error("身份验证异常",e);
            return responseData(3, "身份验证异常", e.getMessage());
        } else if (e instanceof UnauthorizedException) {
            logger.error("权限认证异常",e);
            return responseData(3, "权限认证异常", e.getMessage());
        }
        logger.error("处理异常",e);
        return responseData(1, "处理异常", e.getMessage());
    }

    /**
     *
     * @param requestCode
     * @param msg
     * @param data
     * @return
     */
    protected ResponseData responseData(int requestCode, String msg, Object data) {

        if (data != null) {
            return new ResponseData(requestCode, msg ,data );
        }
        return new ResponseData(requestCode, msg, "");

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

    /**
     * initBinder 初始化绑定
     * @param binder
     * @param request
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder, WebRequest request) {
        // 字符串自动qu
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
    }

    /**
     * 获取权限Subject
     * @return
     */
    protected Subject getSubject(){
        Subject subject = SecurityUtils.getSubject();
        logger.debug("获取权限Subject"+subject.getPrincipal());
        return subject;
    }

    /**
     * 获取session
     * @return
     */
    protected Session getSession(){
        Session session = getSubject().getSession();
        logger.debug("获取会话"+session.toString());
        return session;
    }

}
