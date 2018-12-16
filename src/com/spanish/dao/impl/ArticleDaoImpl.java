package com.spanish.dao.impl;

import com.spanish.bean.Article;
import com.spanish.dao.ArticleDao;
import com.spanish.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ArticleDaoImpl implements ArticleDao {


    @Override
    public Article findArticleById(String articleId) {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from t_article where id = ?";
        try {
            return runner.query(sql,new BeanHandler<Article>(Article.class),articleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Article> findAllArticles() {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from t_article";
        try {
            return runner.query(sql,new BeanListHandler<Article>(Article.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
