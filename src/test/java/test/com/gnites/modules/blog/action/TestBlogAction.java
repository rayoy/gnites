package test.com.gnites.modules.blog.action;

import java.util.Date;

import javax.annotation.Resource;


import org.junit.Test;

import com.gnites.modules.article.model.Article;
import com.gnites.modules.article.service.IArticleService;
import com.gnites.modules.blog.model.Blog;
import com.gnites.modules.blog.service.IBlogService;

import test.TestBaseTemplate;

public class TestBlogAction extends TestBaseTemplate {

	@Resource
	private IBlogService<Blog> blogService;

	@Test
	public void testCreateBlog() {
		Blog  b= new Blog();
		
		b.setName("geek41");
		blogService.save(b);
	}
	
	public void testListArticle(){
		
	}
	
	
	public void testViewArticle(){
//		Article a = articleService.find("4028818a3facf7d8013facf7da6e0001");
//		System.out.println(a.getTitle());
	}
	
}
