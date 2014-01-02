package com.gnites.modules.blog.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.gnites.modules.article.model.Article;
import com.gnites.modules.article.service.IArticleService;
import com.gnites.modules.blog.model.Blog;
import com.gnites.modules.blog.service.IBlogService;
import com.gnites.modules.user.model.User;
import com.gnites.modules.user.service.IUserService;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.sylvan41.action.BaseAction;

@Controller
public class BlogAction extends BaseAction implements ModelDriven<Blog>,
		Preparable {

	private static final long serialVersionUID = -1306094019567714852L;

	@Resource
	private IBlogService<Blog> blogService;
	@Resource
	private IArticleService<Article> articleService;
	@Resource
	private IUserService<User> personService;

	private Blog blog;
	private String blogId;
	private List<Blog> blogList = new ArrayList<Blog>();

	private List<Article> articleList = new ArrayList<Article>();

	private User user;

	private String toUrl;

	public String execute() {

		Blog b = blogService.findByName(getBlog().getName());

		if (b != null) {
			log.info(getBlog().getName() + " blog exist!");
			setBlog(b);
			System.out.println(getBlog().getId());
			// setBlogId(blog.getId());
			return SUCCESS;
		} else {
			log.info("blog no exist..404");
			return ERROR;
		}
	}
	
	public String manage(){
		return SUCCESS;
	}

	@Override
	public void prepare() throws Exception {
		if (getBlogId() == null || "".equals(getBlogId())) {
			blog = new Blog();
		} else {
			blog = blogService.find(getBlogId());
		}
	}

	@Override
	public Blog getModel() {
		return getBlog();
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public List<Blog> getBlogList() {
		return blogList;
	}

	public void setBlogList(List<Blog> blogList) {
		this.blogList = blogList;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getToUrl() {
		return toUrl;
	}

	public void setToUrl(String toUrl) {
		this.toUrl = toUrl;
	}

}
