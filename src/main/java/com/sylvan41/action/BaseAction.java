/**
 * 
 */
package com.sylvan41.action;

import java.io.Serializable;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;
import com.opensymphony.xwork2.ValidationAware;

/**
 * Action 基类,封装了request,response,session
 * @author asimple41@qq.com
 * 
 */
public class BaseAction extends ActionSupport implements SessionAware,
		ServletRequestAware, ServletResponseAware, Serializable, Validateable,
		ValidationAware {

	private static final long serialVersionUID = 1L;

	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected Logger log = Logger.getLogger(this.getClass());

	public BaseAction() {
		// FIXME 默认初始化BaseAction将log级别设为info,以便开发和调试,项目发布请去掉下面这行代码
		log.setLevel(Level.INFO);
	}

	public void setSession(Map<String,Object> session) {
		this.session = session;

	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public ServletContext getServletContext() {
		ActionContext ac = ActionContext.getContext();
		return (ServletContext) ac.get(ServletActionContext.SERVLET_CONTEXT);
	}

}
