package com.spanish.service.impl;

import com.spanish.bean.Article;
import com.spanish.dao.ArticleDao;
import com.spanish.dao.impl.ArticleDaoImpl;
import com.spanish.service.ArticleService;

import java.util.ArrayList;
import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    private ArticleDao articleDao = new ArticleDaoImpl();

    public List<Article> findAllArticles(){
        List<Article> articleList = new ArrayList<>();
        articleList = articleDao.findAllArticles();
        return articleList;
    }



}
