package com.gnites.modules.blog.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gnites.modules.blog.model.Blog;
import com.gnites.modules.blog.service.IBlogService;
import com.sylvan41.service.ServiceImpl;

@Service
public class BlogService extends ServiceImpl<Blog> implements
		IBlogService<Blog> {
	
	

	@Override
	public Blog findByName(String name) {

		Blog b = null;
		List<Blog> blogs = super.findByProperty("name", name);
		if (blogs.size() > 0) {
			b = blogs.get(0);
		}
		return b;
	}

	@Override
	public Blog findByUser(String userId) {
		
		List<Blog> blogs = super.findByProperty("person.id", userId);
		if(blogs.size()>0){
			return blogs.get(0);
		}
		return null;
	}

}
