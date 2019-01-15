package com.spanish.dao.impl;

import com.spanish.bean.Article;
import com.spanish.dao.ArticleDao;
import com.spanish.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ArticleDaoImpl implements ArticleDao {

    private QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

    @Override
    public Article findArticleById(String articleId) {
        String sql = "select * from t_article where id = ?";
        try {
            return runner.query(sql, new BeanHandler<Article>(Article.class), articleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Article> findAllArticles() {
        String sql = "select * from t_article t order by t.lastmodifytime desc";
        try {
            return runner.query(sql, new BeanListHandler<Article>(Article.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void addArticle(Article article) {
        String sql = "insert into t_article(id,title,contentHtml,contentText,inittime,lastmodifytime,publisher,author)" +
                "values(?,?,?,?,?,?,?,?)";
        try {
            runner.update(sql, article.getId(), article.getTitle(), article.getContentHtml(), article.getContentText(), article.getInitTime(), article.getLastModifyTime(), article.getPublisher(), article.getAuthor());
        } catch (SQLException e) {
            System.out.println("添加文章失败...");
            e.printStackTrace();
        }

    }

    @Override
    public Integer getMaxAritcleId() {
        String sql = "select max(id) from t_article";
        try {
            return (Integer) runner.query(DataSourceUtils.getConnection(), sql, new ScalarHandler(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  0;
    }

    @Override
    public void editArticleById(Article article) {
        String sql = "update t_article t set t.title=?,t.contentHtml=?,t.contentText=? where t.id = ?";
        try {
            runner.update(sql,article.getTitle(),article.getContentHtml(),article.getContentText(),article.getId());
        } catch (SQLException e) {
            System.out.println("文章修改失败");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteArticleById(Integer articleId) {
        String sql = "delete from t_article where id = ?";
        try {
            runner.update(sql,articleId);
        } catch (SQLException e) {
            System.out.println("article dao delete article failed");
            e.printStackTrace();
        }
    }


}
