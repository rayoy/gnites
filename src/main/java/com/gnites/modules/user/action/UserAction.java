package com.gnites.modules.user.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gnites.modules.blog.model.Blog;
import com.gnites.modules.blog.service.IBlogService;
import com.gnites.modules.user.model.User;
import com.gnites.modules.user.service.IUserService;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.sylvan41.action.BaseAction;

/**
 * 
 * 
 * @author Sylvan41
 * 
 */
@Controller
@Scope(value = "prototype")
public class UserAction extends BaseAction implements ModelDriven<User>,
		Preparable {

	private static final long serialVersionUID = -6453077789750611664L;

	@Resource
	private IUserService<User> personService;
	@Resource
	private IBlogService<Blog> blogService;

	private User user;
	private String userId;

	private List<User> users = new ArrayList<User>();

	private String toUrl;

	/**
	 * 登录
	 * @return
	 */
	public String login() {

		User p = personService.login(getUser());

		if (p != null) {
			log.info("Login Success !");
			session.put("s_user", p);
			Blog b = blogService.findByUser(p.getId());
			session.put("s_blog", b);
			setToUrl(b.getName());
		} else {
			log.info("Login failure !");
		}
		return SUCCESS;
	}
	
	public String admin(){
		return SUCCESS;
	}
	
	/**
	 * 登出
	 * @return
	 */
	public String logout(){
		session.remove("user");
		return SUCCESS;
	}
	
	@Override
	public void prepare() throws Exception {
		if (getUserId() != null && "".equals(getUserId())) {
			setUser(personService.find(getUserId()));
		} else {
			setUser(new User());
		}
	}

	@Override
	public User getModel() {
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToUrl() {
		return toUrl;
	}

	public void setToUrl(String toUrl) {
		this.toUrl = toUrl;
	}

}
