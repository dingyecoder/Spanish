package com.spanish.service;

import com.spanish.bean.Article;

import java.util.List;

public interface ArticleService {

    List<Article> findAllArticles();

    void addArticle(Article article);

    Integer getMaxArticleId();

    Article getArticleById(String articleId);

    void editArticleById(Article article);

    void deleteArticleById(Integer articleId);

}
