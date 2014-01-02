package test.com.gnites.modules.blog.action;

import javax.annotation.Resource;
import org.junit.Test;

import com.gnites.modules.blog.model.Blog;
import com.gnites.modules.blog.service.IBlogService;
import com.gnites.modules.user.model.User;
import com.gnites.modules.user.service.IUserService;

import test.TestBaseTemplate;

public class TestBlogAction extends TestBaseTemplate {

	@Resource
	private IBlogService<Blog> blogService;

	@Resource
	private IUserService<User> userService;

	@Test
	public void testCreateBlog() {
		Blog b = new Blog();
		User user = new User();
		user.setName("sylvan41");
		b.setUser(userService.findByExample(user).get(0));
		b.setName(user.getName());
		blogService.save(b);
	}

	public void testListArticle() {

	}

	public void testViewArticle() {
		// Article a = articleService.find("4028818a3facf7d8013facf7da6e0001");
		// System.out.println(a.getTitle());
	}

}
