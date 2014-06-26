package com.gnites.modules.article.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gnites.modules.article.model.ArticleCategory;
import com.gnites.modules.article.service.IArticleCategoryService;
import com.gnites.modules.blog.model.Blog;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.sylvan41.action.BaseAction;
import com.sylvan41.utils.JsonUtil;

@Controller
@Scope(value = "prototype")
public class ArticleCategoryAction extends BaseAction implements ModelDriven<ArticleCategory>,
		Preparable {


	private static final long serialVersionUID = 7931844634667152097L;

	@Resource
	private IArticleCategoryService<ArticleCategory> articleCategoryService;

	private ArticleCategory articleCategory;
	private String articleCategoryId;
	private List<ArticleCategory> articleCategoryList = new ArrayList<ArticleCategory>();
	
	private String blogId;
	private String parentId;
	
	public String create(){
		return SUCCESS;
	}

	public String execute() {

		return SUCCESS;
	}

	
	public String list(){
		setArticleCategoryList(articleCategoryService.findByProperty("blog.id", getBlogId(), 0, 12));
		return SUCCESS;
	}
	
	public String modify(){
		return SUCCESS;
	}
	
	public String jsonList(){
		
		if(getBlogId()==null||"".equals(getBlogId())){
			Blog b = (Blog) session.get("s_blog");
			setBlogId(b.getId());
		}
		setArticleCategoryList(articleCategoryService.findByProperty("blog.id", getBlogId(), 0, 12));
		JsonUtil.toJsonArray(articleCategoryList, response);
		return SUCCESS;
	}
	
	public String save(){
		System.out.println("...");
		if(getParentId()!=null&&!"".equals(getParentId())){
			articleCategory.setParent(articleCategoryService.find(getParentId()));
		}else{
			articleCategory.setParent(null);
		}
		Blog b = (Blog) session.get("s_blog");
		setBlogId(b.getId());
		articleCategory.setBlog(b);
		articleCategoryService.save(getArticleCategory());
		return SUCCESS;
	}
	
	
	@Override
	public void prepare() throws Exception {
		if (getArticleCategoryId() == null || "".equals(getArticleCategoryId())) {
			articleCategory = new ArticleCategory();
		} else {
			articleCategory = articleCategoryService.find(getArticleCategoryId());
		}
	}

	@Override
	public ArticleCategory getModel() {
		return getArticleCategory();
	}

	public ArticleCategory getArticleCategory() {
		return articleCategory;
	}

	public void setArticleCategory(ArticleCategory articleCategory) {
		this.articleCategory = articleCategory;
	}

	public String getArticleCategoryId() {
		return articleCategoryId;
	}

	public void setArticleCategoryId(String articleCategoryId) {
		this.articleCategoryId = articleCategoryId;
	}

	public List<ArticleCategory> getArticleCategoryList() {
		return articleCategoryList;
	}

	public void setArticleCategoryList(List<ArticleCategory> articleCategoryList) {
		this.articleCategoryList = articleCategoryList;
	}


	public String getBlogId() {
		return blogId;
	}


	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

}
