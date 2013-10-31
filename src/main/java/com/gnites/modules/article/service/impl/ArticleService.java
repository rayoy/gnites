package com.gnites.modules.article.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gnites.modules.article.model.Article;
import com.gnites.modules.article.service.IArticleService;
import com.sylvan41.service.ServiceImpl;

@Service
// @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ArticleService extends ServiceImpl<Article> implements
		IArticleService<Article> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gnites.modules.article.service.IArticleService#publishArticle(java
	 * .lang.Object)
	 */
	@Transactional
	public Boolean publishArticle(Article a) {
		Boolean flag = false;
		try {
			a.setPublishTime(new Date());
			super.save(a);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public void BatchDelectByIds(String[] ids) {
		for (String id : ids) {
			super.DeleteById(id);
		}

	}

}
