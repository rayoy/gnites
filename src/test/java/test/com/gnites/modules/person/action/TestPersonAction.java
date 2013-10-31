package test.com.gnites.modules.person.action;


import javax.annotation.Resource;


import org.junit.Test;

import com.gnites.modules.person.model.Person;
import com.gnites.modules.person.service.IPersonService;

import test.TestBaseTemplate;

public class TestPersonAction extends TestBaseTemplate {

	@Resource
	private IPersonService<Person> personService;

	@Test
	public void testPersonRegister() {
		Person  p = new Person();
		p.setNicName("sylvan41");
		p.setEmail("ddddd@gmail.com");
		personService.save(p);
		
		p = new Person();
		p.setNicName("主编");
		p.setEmail("ddddd@gmail.com");
		personService.save(p);
		
		p = new Person();
		p.setNicName("系统管理员");
		p.setEmail("ddddd@gmail.com");
		personService.save(p);
	}
	
	public void testListArticle(){
		
	}
	
	
	public void testViewArticle(){
//		Article a = articleService.find("4028818a3facf7d8013facf7da6e0001");
//		System.out.println(a.getTitle());
	}
	
}
