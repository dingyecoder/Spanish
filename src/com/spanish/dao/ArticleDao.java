package com.spanish.dao;


import com.spanish.bean.Article;

import java.util.List;

public interface ArticleDao {

    Article findArticleById(String articleId);

    List<Article> findAllArticles();


}
