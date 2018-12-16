package com.spanish.servlet;

import com.spanish.bean.Sentence;
import com.spanish.service.SentenceService;
import com.spanish.service.impl.SentenceServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class ServletSentence extends HttpServlet {
    SentenceService sentenceService = new SentenceServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String methodName = request.getParameter("method");
        System.out.println("methodName : " + methodName);

        Method method = null;
        try {
            method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            if (null != method) {
                method.invoke(this, request, response);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("方法 " + method + " 设置失败...");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println("方法 " + methodName + " 执行失败 ... ");
            e.printStackTrace();
        }


    }


    protected void addSentence(HttpServletRequest request, HttpServletResponse response) {
        String sentenceValue = request.getParameter("sentence");
        System.out.println("每日一句： " + sentenceValue);
        Integer maxSentenceId = sentenceService.getMaxSentenceId();
        if (null != maxSentenceId && maxSentenceId != 0) {
            Sentence sentence = new Sentence();
            sentence.setSentence(sentenceValue);
            sentence.setId(maxSentenceId + 1);
            sentence.setUpdateTime(new Date());
            sentence.setInitTime(new Date());
            sentenceService.addSentence(sentence);
        } else {
            System.out.println("database spanish's table t_sentence can't obtain maxId");
        }


    }

}
