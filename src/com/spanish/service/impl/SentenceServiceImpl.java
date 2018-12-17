package com.spanish.service.impl;

import com.spanish.bean.Sentence;
import com.spanish.dao.SentenceDao;
import com.spanish.dao.impl.SentenceDaoImpl;
import com.spanish.service.SentenceService;

import java.util.List;

public class SentenceServiceImpl implements SentenceService {
    private SentenceDao sentenceDao = new SentenceDaoImpl();

    @Override
    public Sentence findSentenceById(Integer sentenceId) {
        return sentenceDao.findSentenceById(sentenceId);
    }

    @Override
    public List<Sentence> findAllSentences() {
        return sentenceDao.findAllSentences();
    }

    @Override
    public void addSentence(Sentence sentence) {
        sentenceDao.addSentence(sentence);
    }

    @Override
    public Integer getMaxSentenceId() {
        return sentenceDao.getMaxSentenceId();
    }
}
