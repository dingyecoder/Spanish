package com.spanish.servlet;

import com.spanish.bean.Article;
import com.spanish.service.ArticleService;
import com.spanish.service.impl.ArticleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;


public class ServletArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodName = request.getParameter("method");
        System.out.println(methodName);
        Method method = null;
        try {
            method = getClass().getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected  void addArticle(HttpServletRequest request,HttpServletResponse response){

        ArticleService articleService = new ArticleServiceImpl();
        Integer maxArticleId = articleService.getMaxArticleId();
        if(null != maxArticleId && maxArticleId != 0){
            try {
                request.setCharacterEncoding("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String articleTitle = request.getParameter("articleTitle");
            String articleContentHtml = request.getParameter("articleContentHtml");
            String articleContentText = request.getParameter("articleContentText");

            Article article = new Article();
            article.setId(maxArticleId + 1);
            article.setTitle(articleTitle);
            article.setInitTime(new Date());
            article.setLastModifyTime(new Date());
            article.setContentHtml(articleContentHtml);
            article.setContentText(articleContentText);

            System.out.println(article);
            articleService.addArticle(article);
        }else{
            System.out.println("获取文章最大id报错");
        }

    }

    protected void findAllArticles(HttpServletRequest request,HttpServletResponse response){

        ArticleService articleService = new ArticleServiceImpl();
        List<Article> articleList  = articleService.findAllArticles();
        System.out.println(articleList);
    }
}
