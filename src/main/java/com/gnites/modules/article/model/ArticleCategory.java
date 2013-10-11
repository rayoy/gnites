package com.gnites.modules.article.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.gnites.modules.blog.model.Blog;
import com.sylvan41.model.BaseEntity;

@Entity
public class ArticleCategory extends BaseEntity{

	private static final long serialVersionUID = 7057682419603835475L;
	
	@Id 
	@GeneratedValue(generator = "system-uuid")  
    @GenericGenerator(name = "system-uuid", strategy = "uuid")  
	private String id;
	
	private String name;
	
	@ManyToOne
	private ArticleCategory parent;
	
	@ManyToOne
	private Blog blog;
	
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArticleCategory getParent() {
		return parent;
	}

	public void setParent(ArticleCategory parent) {
		this.parent = parent;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

}
