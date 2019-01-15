package com.spanish.bean.com.spanish.bean.json;

import com.spanish.bean.Sentence;
import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleJson {


    public static void main(String[] args) {
        Sentence s1 = new Sentence();
        s1.setId(1);
        s1.setInitTime(new Date());
        s1.setUpdateTime(new Date());
        s1.setSentence("sentence1...");
        s1.setPublisher("s1 publisher1");

        Sentence s2 = new Sentence();
        s1.setId(2);
        s1.setInitTime(new Date());
        s1.setUpdateTime(new Date());
        s1.setSentence("sentence2...");
        s1.setPublisher("s1 publisher2");

        List<Sentence> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);

        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println(jsonArray.toString());

    }





}
