package com.gnites.modules.article.service;

import com.sylvan41.service.IService;

public interface IArticleService<T> extends IService<T>{
	
	/**
	 * 发布文章
	 * 
	 * @param a 文章实例
	 * @return
	 */
	public Boolean publishArticle(T a);

}
