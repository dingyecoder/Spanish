package com.spanish.service;

import com.spanish.bean.Sentence;
import java.util.List;

public interface SentenceService {
    Sentence findSentenceById(Integer sentenceId);

    List<Sentence> findAllSentences();

    void addSentence(Sentence sentence);

    Integer getMaxSentenceId();

}
