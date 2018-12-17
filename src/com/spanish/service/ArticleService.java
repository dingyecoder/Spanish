package com.spanish.service;

import com.spanish.bean.Article;

import java.util.List;

public interface ArticleService {

    List<Article> findAllArticles();

    void addArticle(Article article);

    Integer getMaxArticleId();

}
