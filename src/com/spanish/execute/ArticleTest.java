package com.spanish.execute;

import com.spanish.bean.Article;
import com.spanish.dao.ArticleDao;
import com.spanish.dao.impl.ArticleDaoImpl;
import com.spanish.utils.DataSourceUtils;
import org.junit.Test;

import java.util.List;

public class ArticleTest {

    @Test
    public void findAllArticles(){
        ArticleDao articleDao = new ArticleDaoImpl();
        List<Article> articleList = articleDao.findAllArticles();
        System.out.println(articleList);
    }

    @Test
    public void findMaxArticleId(){
        ArticleDao articleDao = new ArticleDaoImpl();
        Integer maxId = articleDao.getMaxAritcleId();
        System.out.println(maxId);
    }

}
