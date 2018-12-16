package com.spanish.dao.impl;

import com.spanish.bean.Sentence;
import com.spanish.dao.SentenceDao;
import com.spanish.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class SentenceDaoImpl implements SentenceDao {
    QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

    @Override
    public List<Sentence> findAllSentences() {
        //QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from t_sentence";
        try {
            return runner.query(sql, new BeanListHandler<Sentence>(Sentence.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Sentence findSentenceById(Integer sentenceId) {
        String sql = "select * from t_sentence where id = ? ";
        //QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return runner.query(sql, new BeanHandler<Sentence>(Sentence.class), sentenceId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addSentence(Sentence sentence) {
        String sql = "insert into t_sentence(id,sentence,inittime,updatetime,publisher) values(?,?,?,?,?)";
        //QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            runner.update(sql, sentence.getId(), sentence.getSentence(), sentence.getInitTime(), sentence.getUpdateTime(), sentence.getPublisher());
        } catch (SQLException e) {
            System.out.println("添加语句失败！！！");
            e.printStackTrace();

        }
    }

    @Override
    public Integer getMaxSentenceId() {
        String sql = "select max(id) from t_sentence ";
        try {

            return (Integer) runner.query(DataSourceUtils.getConnection(), sql,new ScalarHandler(1));
            //return runner.query(sql,new ScalarHandler<Long>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
        //return 0;
    }
}
