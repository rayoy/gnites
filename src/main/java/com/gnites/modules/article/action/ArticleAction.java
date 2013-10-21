package com.gnites.modules.article.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gnites.modules.article.model.Article;
import com.gnites.modules.article.service.IArticleService;
import com.gnites.modules.blog.model.Blog;
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

	private Article article;
	private String articleId;
	private List<Article> articleList = new ArrayList<Article>();
	
	private String blogId;
	
	public String create(){
		
		
		
		return SUCCESS;
	}

	public String execute() {

		return SUCCESS;
	}

	
	
	
	public String delete(){
		
		articleService.DeleteById(getArticleId());
		
		return SUCCESS;
		
	}
	
	public String list(){
		
		setArticleList(articleService.findByProperty("blog.id",getBlogId(), 0, 12));
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

		Blog blog = (Blog) session.get("myBlog");
		getArticle().setBlog(blog);
		if (articleService.publishArticle(getArticle())) {
			log.info("Publish SUCCESS...");
		} else {
			log.error("Article publish failure!!!");
		}
		return SUCCESS;
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
