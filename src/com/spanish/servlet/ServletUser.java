package com.spanish.servlet;

import com.spanish.bean.User;
import com.spanish.service.UserService;
import com.spanish.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class ServletUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  methodName = request.getParameter("method");
        Method method = null;
        try {
            method = getClass().getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this,request,response);
        } catch (NoSuchMethodException e) {
            System.out.println("找不到方法: " + methodName);
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println(methodName+ "方法执行失败");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    protected void addUser(HttpServletRequest request,HttpServletResponse response){
        doCharacter(request,response);

        UserService userService = new UserServiceImpl();
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");

        System.out.println(password);
        System.out.println(repassword);

        if(null != password && null != repassword && password.equals(repassword)){
            String username = request.getParameter("username");

            String role = "1";
            Date createTime = new Date();
            String  phone = request.getParameter("phone");
            String mail = request.getParameter("mail");

            User user = new User();
            Integer maxUserId = userService.getMaxUserId();
            if(null == maxUserId){
                maxUserId = 0;
            }
            user.setId(maxUserId+1);
            user.setCreateTime(createTime);
            user.setPhone(phone);
            user.setMail(mail);

            userService.addUser(user);
        }else{
            System.out.println("用户输入密码不一致");
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
