package com.gnites.modules.article.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gnites.modules.article.model.Article;
import com.gnites.modules.article.service.IArticleService;
import com.gnites.modules.blog.model.Blog;
import com.gnites.modules.user.model.User;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.sylvan41.action.BaseAction;

@Controller
@Scope(value = "prototype")
public class ArticleAction extends BaseAction implements ModelDriven<Article>,
		Preparable {

	private static final long serialVersionUID = -5109360404099942318L;

	@Resource
	private IArticleService<Article> articleService;

	@Resource
	private RuntimeService runtimeService;

	@Resource
	private RepositoryService repositoryService;
	
	@Resource
	private IdentityService identityService;

	private Article article;
	private String articleId;
	private List<Article> articleList = new ArrayList<Article>();

	private String blogId;
	private Boolean isAdmin;
	
	

	public String create() {

		return SUCCESS;
	}

	public String execute() {

		return SUCCESS;
	}

	public String delete() {

		articleService.DeleteById(getArticleId());

		return SUCCESS;

	}

	public String list() {

		if(isAdmin){
			setBlogId(((Blog)session.get("s_blog")).getId());
		}
		
		setArticleList(articleService.findByProperty("blog.id", getBlogId(), 0,
				12));
		System.out.println(getArticleList().size());
		return SUCCESS;
	}

	/**
	 * Save
	 * 
	 * @return
	 * 
	 */
	public String save() {
		return SUCCESS;
	}

	/**
	 * Publish
	 * 
	 * @return
	 */
	public String publishArticle() {

		log.info("================== Publish Article Action=====================");

		User u = (User) session.get("s_user");
		Blog blog = (Blog) session.get("s_blog");
		getArticle().setBlog(blog);
		if (articleService.publishArticle(getArticle())) {
			log.info("Publish SUCCESS...");

			// 启动审核流程
			this.startProcess(u.getId());

		} else {
			log.error("Article publish failure!!!");
		}
		return SUCCESS;
	}

	/**
	 * 启动流程
	 */
	public void startProcess(String uid) {
		// 部署流程定义
		repositoryService.createDeployment()
				.addClasspathResource("test.bpmn20.xml").deploy();
		
		 // 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
	    identityService.setAuthenticatedUserId(uid);
		// 启动流程实例
		runtimeService.startProcessInstanceByKey("articlePublish");
		log.info("articlePublish流程启动。。。,inititorUserId:"+uid);
	}

	@Override
	public void prepare() throws Exception {
		if (getArticleId() == null || "".equals(getArticleId())) {
			article = new Article();
		} else {
			article = articleService.find(getArticleId());
		}
	}

	@Override
	public Article getModel() {
		return getArticle();
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

}
