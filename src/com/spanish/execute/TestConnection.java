package com.spanish.execute;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.spanish.bean.Article;
import com.spanish.dao.ArticleDao;
import com.spanish.dao.impl.ArticleDaoImpl;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class TestConnection {


    @Test
    public void testFindAllArticles(){
        List<Article> articleList = new ArticleDaoImpl().findAllArticles();
        System.out.println(articleList);
    }


    @Test
    public void testArticle(){
        ArticleDao articleDao = new ArticleDaoImpl();
        Article article = articleDao.findArticleById("1");
        System.out.println(article);
    }

    @Test
    public void testC3P0() throws SQLException {
        System.out.println(1123);
        DataSource dataSource = new ComboPooledDataSource();
        Connection conn = dataSource.getConnection();
        System.out.println(conn);

    }

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        String dbDrive = "com.mysql.jdbc.Driver";
       // Class.forName("com.mysql.jdbc.Driver");
        Class.forName(dbDrive).newInstance();
        String url = "jdbc:mysql://192.168.206.135:3306/spanish";
        conn = DriverManager.getConnection(url,"root","dy19930121!");
        System.out.println(111);
        System.out.println(conn);
    }

}
