package test.com.gnites.modules;

import javax.annotation.Resource;

import org.activiti.engine.RepositoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;
import test.TestBaseTemplate;

public class TestActiviti extends TestBaseTemplate{
	
	@Resource
	@Autowired
	private RepositoryService repositoryService ;
	
	@Test
	public void testProcessEngine(){
		
		assertNotNull(repositoryService);
		
	}

}
