package com.spanish.execute;

import com.spanish.bean.Sentence;
import com.spanish.dao.SentenceDao;
import com.spanish.dao.impl.SentenceDaoImpl;
import org.junit.Test;

import java.util.Date;

public class SentenceTest {

    @Test
    public void getMaxSentenceId(){
        SentenceDao sentenceDao = new SentenceDaoImpl();
        Integer id  = sentenceDao.getMaxSentenceId();
        System.out.println(id);

    }

    @Test
    public void addSentence(){
        Sentence sentence = new Sentence();
        sentence.setId(3);
        sentence.setSentence("test add sentence 3 ");
        sentence.setInitTime(new Date());
        //sentence.setUpdateTime(new Date());
       // sentence.setPublisher("test publisher ");
        SentenceDao sentenceDao = new SentenceDaoImpl();
        sentenceDao.addSentence(sentence);
    }

    @Test
    public void testSentence(){
        Integer sentenceId = 1;
        SentenceDao sentenceDao = new SentenceDaoImpl();
       // List<Sentence> sentenceList = sentenceDao.findAllSentences();
        Sentence sentence  = sentenceDao.findSentenceById(sentenceId);
        //System.out.println(sentenceList);
        System.out.println("------------------------------------------");
        System.out.println(sentence);
    }
}
