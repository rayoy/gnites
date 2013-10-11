package com.gnites.modules.blog.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.gnites.modules.article.model.Article;
import com.gnites.modules.article.service.IArticleService;
import com.gnites.modules.blog.model.Blog;
import com.gnites.modules.blog.service.IBlogService;
import com.gnites.modules.person.model.Person;
import com.gnites.modules.person.service.IPersonService;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.sylvan41.action.BaseAction;

@Controller
public class BlogAction extends BaseAction implements ModelDriven<Blog>,
		Preparable {

	private static final long serialVersionUID = -1306094019567714852L;
	private static final String URL = "url";

	@Resource
	private IBlogService<Blog> blogService;
	@Resource
	private IArticleService<Article> articleService;
	@Resource
	private IPersonService<Person> personService;

	private Blog blog;
	private String blogId;
	private List<Blog> blogList = new ArrayList<Blog>();
	
	private List<Article> articleList = new ArrayList<Article>();
	
	private Person user;
	
	private String toUrl;

	public String execute() {

		
		// check if exist
		Blog blog = blogService.findByName(getBlog().getName());
		Blog b  = (Blog) session.get("myBlog");

		if (blog != null) {
			log.info(getBlog().getName()+" blog exist!");
			setArticleList(articleService.findByProperty("blog.id",blog.getId(), 0, 12));
			setUser(blog.getPerson());
			setBlogId(blog.getId());
			// CHECK IS IT MY BLOG?
			if(b!=null){
				if(b.getId().equals(blog.getId())){
					return "myblog";
				}
			}
			
			
			return SUCCESS;
		} else {
			log.info("blog no exist..404");
			return ERROR;
		}
		// Pagination pg = new Pagination(request, response);
		//
		// Integer count = blogService.getCountByProperty("name", getBlog()
		// .getName());
		// pg.setRecordCount(count);
		//
		// blogList = blogService.findByProperty("name", getBlog().getName(),
		// pg.getFirstResult(), pg.getPageSize());
		//
		// System.out.println("I'm in progress.."+getBlogName()+getBlog().getName());
	}

	/**
	 * Enter My Blog
	 * 
	 * @return
	 */
	public String myBlog(){
		Blog b = (Blog) session.get("myBlog");
		setToUrl(b.getName());
		return URL;
	}
	
	/**
	 * 查看blog
	 * @return
	 */
	public String view(){
		setBlog(blogService.find(getBlogId()));
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

	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}

	public String getToUrl() {
		return toUrl;
	}

	public void setToUrl(String toUrl) {
		this.toUrl = toUrl;
	}


}
