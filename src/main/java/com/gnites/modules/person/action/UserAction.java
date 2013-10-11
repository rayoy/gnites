package com.gnites.modules.person.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gnites.modules.blog.model.Blog;
import com.gnites.modules.blog.service.IBlogService;
import com.gnites.modules.person.model.Person;
import com.gnites.modules.person.service.IPersonService;
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
public class UserAction extends BaseAction implements ModelDriven<Person>,
		Preparable {

	private static final long serialVersionUID = -6453077789750611664L;

	@Resource
	private IPersonService<Person> personService;
	@Resource
	private IBlogService<Blog> blogService;

	private Person user;
	private String userId;

	private List<Person> users = new ArrayList<Person>();

	private String toUrl;

	@SuppressWarnings("unchecked")
	public String login() {

		Person p = personService.loginUser(getUser());

		if (p != null) {
			log.info("Login Success !");
			session.put("user", p);
			Blog b = blogService.findByUser(p.getId());
			session.put("myBlog", b);
			setToUrl(b.getName());
		} else {
			log.info("Login failure !");
		}
		return SUCCESS;
	}

	@Override
	public void prepare() throws Exception {
		if (getUserId() != null && "".equals(getUserId())) {
			setUser(personService.find(getUserId()));
		} else {
			setUser(new Person());
		}
	}

	@Override
	public Person getModel() {
		return user;
	}

	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}

	public List<Person> getUsers() {
		return users;
	}

	public void setUsers(List<Person> users) {
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
