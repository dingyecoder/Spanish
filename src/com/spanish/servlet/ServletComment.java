package com.spanish.servlet;

import com.spanish.bean.Comment;
import com.spanish.service.CommentService;
import com.spanish.service.impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.List;

public class ServletComment extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    protected  void getAllCommentByArticleId(HttpServletRequest request,HttpServletResponse response){
        String articleId = request.getParameter("articleId");
        CommentService commentService = new CommentServiceImpl();
        List<Comment> commentList =  commentService.getAllCommentByArticleId(Integer.valueOf(articleId));
        System.out.println(commentList);
        request.setAttribute("comments",commentList);
        try {
            request.getRequestDispatcher("/listCommentByArticleId.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void findAllComment(HttpServletRequest request,HttpServletResponse response){
        CommentService commentService = new CommentServiceImpl();
        List<Comment> commentList = commentService.getAllComment();
        System.out.println(commentList);
        request.setAttribute("comments",commentList);

        try {
            request.getRequestDispatcher("/listComment.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
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

}
