package test.com.gnites.modules.article.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;


import org.junit.Test;

import com.gnites.modules.article.model.Article;
import com.gnites.modules.article.model.ArticleCategory;
import com.gnites.modules.article.service.IArticleCategoryService;

import test.TestBaseTemplate;

public class TestArticleCategoryAction extends TestBaseTemplate {

	@Resource
	private IArticleCategoryService<ArticleCategory> articleCategoryService;

	@Test
	public void testCreateCategory() {
		ArticleCategory ac = new ArticleCategory();

		ac.setName("编程开发");
		articleCategoryService.save(ac);
	}
	
	//@Test
	public void testListArticle(){
		List<Article> articles = new ArrayList<Article>();
		//articles = articleService.findByProperty("blog.id", "4028818b3fc2562c013fc2562ef10001", 0, 12);
		System.out.println(articles.size());
	}
	
	//@Test
	public void testViewArticle(){
		//Article a = articleService.find("4028818a3facf7d8013facf7da6e0001");
		//System.out.println(a.getTitle());
	}
	
	
	
}
