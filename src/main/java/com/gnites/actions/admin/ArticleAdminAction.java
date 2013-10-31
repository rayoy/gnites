package com.gnites.actions.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gnites.modules.article.model.Article;
import com.gnites.modules.article.service.IArticleService;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.sylvan41.action.CRUDMethod;
import com.sylvan41.utils.Pagination;

@Controller
@Scope(value = "prototype")
public class ArticleAdminAction extends AdminAction implements
		ModelDriven<Article>, Preparable,CRUDMethod {

	private static final long serialVersionUID = -6361429535065342585L;

	@Resource
	private IArticleService<Article> articleService;
	private List<Article> articles = new ArrayList<Article>();
	private String articleId;
	private Article article;
	private String blogId;

	
	@Override
	public String create() {
		return SUCCESS;
	}
	
	@Override
	public String delete() {
		String[] ids = getArticleId().split(",");
		articleService.BatchDelectByIds(ids);
		return SUCCESS;
	}


	@Override
	public String modify() {
		return SUCCESS;
	}


	@Override
	public String query() {
		return SUCCESS;
	}


	@Override
	public String update() {
		articleService.update(getArticle());
		return SUCCESS;
	}
	
	public String list() {

		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("blog.id", getBlogId());
		Pagination pg = new Pagination(request, response);
		pg.setPageCount(articleService.getCountByProperty("blog.id",
				getBlogId()));
		articles = articleService.findByProperties(properties,
				pg.getFirstResult(), pg.getPageSize());
		return SUCCESS;
	}

	
	public String save(){
		
		articleService.save(getArticle());
		return SUCCESS;
	}
	
	
	
	
	
	
	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
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

}
