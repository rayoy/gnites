package com.gnites.modules.blog.service;

import com.gnites.modules.blog.model.Blog;
import com.sylvan41.service.IService;

public interface IBlogService<T> extends IService<T> {

	Blog findByName(String name);

	/**
	 * 
	 * @return
	 */
	public Blog findByUser(String userId);

}
