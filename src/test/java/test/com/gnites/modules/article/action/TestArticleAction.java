package test.com.gnites.modules.article.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.Test;

import com.gnites.modules.article.model.Article;
import com.gnites.modules.article.model.ArticleCategory;
import com.gnites.modules.article.service.IArticleCategoryService;
import com.gnites.modules.article.service.IArticleService;
import com.gnites.modules.blog.model.Blog;
import com.gnites.modules.blog.service.IBlogService;

import test.TestBaseTemplate;

public class TestArticleAction extends TestBaseTemplate {

	@Resource
	private IArticleService<Article> articleService;
	@Resource
	private IBlogService<Blog> blogService;
	@Resource
	private IArticleCategoryService<ArticleCategory> categoryService;
	
	public static void main(String[] args){
		new TestArticleAction().getRandomWords(0) ;
	}

	@Test
	public void testPublishArticle() {
		
		for(int i=0;i<20;i++){
			Article a = new Article();
			a.setTitle(getRandomWords(15));
			a.setContent("<p>"+getRandomWords(2215)+"</p>");
			a.setPublishTime(new Date());
			a.setBlog(blogService.findAll().get(0));
			a.setCategory(categoryService.findAll().get(0));
			articleService.publishArticle(a);
		}
		
	}

	// @Test
	public void testListArticle() {
		List<Article> articles = new ArrayList<Article>();
		articles = articleService.findByProperty("blog.id",
				"4028818b3fc2562c013fc2562ef10001", 0, 12);
		System.out.println(articles.size());
	}

	// @Test
	public void testViewArticle() {
		Article a = articleService.find("4028818a3facf7d8013facf7da6e0001");
		System.out.println(a.getTitle());
	}

	//@Test
	public String getRandomWords(Integer maxLength) {
		
		StringBuffer sb = new StringBuffer();
		String[] words = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
				"w", "x", "y", "z",",","。","?","!" };
		for(int i=0;i<maxLength;i++){
			String dd = words[new Random().nextInt(29)];
			if(new Random().nextBoolean()){
				dd= dd.toUpperCase();
			}
			sb.append(dd);
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

}
