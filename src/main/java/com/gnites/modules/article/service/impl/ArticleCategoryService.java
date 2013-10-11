package com.gnites.modules.article.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gnites.modules.article.model.ArticleCategory;
import com.gnites.modules.article.service.IArticleCategoryService;
import com.sylvan41.service.ServiceImpl;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ArticleCategoryService extends ServiceImpl<ArticleCategory> implements IArticleCategoryService<ArticleCategory> {

}
