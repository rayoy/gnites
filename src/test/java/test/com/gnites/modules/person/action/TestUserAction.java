package test.com.gnites.modules.person.action;


import javax.annotation.Resource;




import org.junit.Test;




import com.gnites.modules.user.model.User;
import com.gnites.modules.user.service.IUserService;

import test.TestBaseTemplate;

public class TestUserAction extends TestBaseTemplate {

	@Resource
	private IUserService<User> personService;

	@Test
	public void testUserRegister() {
		
		User  p = new User();
		p.setName("sylvan41");
		p.setNicName("sylvan41");
		p.setEmail("ddddd@gmail.com");
		p.setPassword("123456");
		personService.save(p);
		
//		p = new User();
//		p.setNicName("主编");
//		p.setEmail("ddddd@gmail.com");
//		personService.save(p);
//		
//		p = new User();
//		p.setNicName("系统管理员");
//		p.setEmail("ddddd@gmail.com");
//		personService.save(p);
	}
	
	public void testListArticle(){
		
	}
	
	
	public void testViewArticle(){
//		Article a = articleService.find("4028818a3facf7d8013facf7da6e0001");
//		System.out.println(a.getTitle());
	}
	
}
