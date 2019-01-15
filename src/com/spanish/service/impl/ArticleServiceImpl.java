package com.spanish.service.impl;

import com.spanish.bean.Article;
import com.spanish.dao.ArticleDao;
import com.spanish.dao.impl.ArticleDaoImpl;
import com.spanish.service.ArticleService;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    private ArticleDao articleDao = new ArticleDaoImpl();

    public List<Article> findAllArticles() {
        List<Article> articleList = articleDao.findAllArticles();
        return articleList;
    }

    @Override
    public void addArticle(Article article) {
        articleDao.addArticle(article);
    }

    @Override
    public Integer getMaxArticleId() {
        return articleDao.getMaxAritcleId();
    }

    @Override
    public Article getArticleById(String articleId) {
        return articleDao.findArticleById(articleId);
    }

    @Override
    public void editArticleById(Article article) {
        articleDao.editArticleById(article);
    }

    @Override
    public void deleteArticleById(Integer articleId) {
        articleDao.deleteArticleById(articleId);
    }


}
