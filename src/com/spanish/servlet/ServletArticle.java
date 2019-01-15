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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
        doCharacter(request,response);
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

    private void doCharacter(HttpServletRequest request,HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("不能处理字符乱码问题");
            e.printStackTrace();
        }

    }

    protected void deleteArticleById(HttpServletRequest request,HttpServletResponse response){
        String articleId = request.getParameter("articleId");
        ArticleService articleService = new ArticleServiceImpl();
        articleService.deleteArticleById(Integer.valueOf(articleId));
        findAllArticles(request,response);
    }

    protected void editArticleGet(HttpServletRequest request,HttpServletResponse response){
        ArticleService articleService = new ArticleServiceImpl();
        String articleId = request.getParameter("articleId");
        System.out.println(articleId);
        Article article = articleService.getArticleById(articleId);
        request.setAttribute("article",article);
        try {
            request.getRequestDispatcher("/editArticle.jsp").forward(request,response);
        } catch (ServletException e) {
            System.out.println("Servlet 异常");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void editArticlePost(HttpServletRequest request,HttpServletResponse response){
        String articleId = request.getParameter("articleId");
        String articleTitle = request.getParameter("articleTitle");
        String articleContentHtml = request.getParameter("articleContentHtml");
        String articleContentText = request.getParameter("articleContentText");

        Article article = new Article();
        article.setId(Integer.valueOf(articleId));
        article.setContentText(articleContentText);
        article.setContentHtml(articleContentHtml);
        article.setTitle(articleTitle);
        article.setLastModifyTime(new Date());

        ArticleService articleService = new ArticleServiceImpl();
        articleService.editArticleById(article);

        findAllArticles(request,response);
    }

    protected  void addArticle(HttpServletRequest request,HttpServletResponse response){
        String postOrGet = request.getMethod();
        System.out.println(postOrGet);

        try {
            if(postOrGet.equals("GET")){
            request.getRequestDispatcher("/addArticle.jsp").forward(request,response);}
            else if (postOrGet.equals("POST")){
                addArticlePost(request,response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void  editArticle(HttpServletRequest request,HttpServletResponse response){
        String postORGet = request.getMethod();
        System.out.println(postORGet);
        if(postORGet.equals("GET")){
            editArticleGet(request,response);
        }else if(postORGet.equals("POST")){
            editArticlePost(request,response);
        }
    }


    protected  void addArticlePost(HttpServletRequest request,HttpServletResponse response){

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

            findAllArticles(request,response);
        }else{
            System.out.println("获取文章最大id报错");
        }

    }


    protected void findAllArticles(HttpServletRequest request,HttpServletResponse response){
        ArticleService articleService = new ArticleServiceImpl();
        List<Article> articleList  = articleService.findAllArticles();
        /*JSONArray jsonArray = JSONArray.fromObject(articleList);
        System.out.println(articleList);
        try {
            response.getWriter().println(jsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        if(null != articleList){
            request.setAttribute("articles",articleList);
            try {
                request.getRequestDispatcher("/listArticle.jsp").forward(request,response);
            } catch (ServletException e) {
                System.out.println("异常： 没有找到listArticle.jsp页面");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("findAllArticles失败...");
        }
    }
}
