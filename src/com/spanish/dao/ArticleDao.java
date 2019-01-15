package com.spanish.dao;


import com.spanish.bean.Article;

import java.util.List;

public interface ArticleDao {

    Article findArticleById(String articleId);

    List<Article> findAllArticles();

    void addArticle(Article article);

    Integer getMaxAritcleId();

    void editArticleById(Article article);

    void deleteArticleById(Integer articleId);

}
