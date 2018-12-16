package com.spanish.dao;

import com.spanish.bean.Sentence;

import java.util.List;

public interface SentenceDao {

    List<Sentence> findAllSentences();

    Sentence findSentenceById(Integer sentenceId);

    void addSentence(Sentence sentence);

    Integer getMaxSentenceId();

}
