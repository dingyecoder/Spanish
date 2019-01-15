package com.spanish.dao.impl;

import com.spanish.bean.Comment;
import com.spanish.dao.CommentDao;
import com.spanish.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CommentDaoImpl implements CommentDao {
    private QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

    @Override
    public List<Comment> findAllComments() {
        String sql = "select * from t_comment t order by t.createTime";
        try {
            return runner.query(sql,new BeanListHandler<>(Comment.class));
        } catch (SQLException e) {
            System.out.println("commentDao find all comments fail");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addComment(Comment comment) {

    }

    @Override
    public List<Comment> getAllCommentByArticleId(int articleId) {

        String sql = "select * from t_comment where articleId = ? order by createTime asc";
        try {
            return runner.query(sql,new BeanListHandler<>(Comment.class),articleId);
        } catch (SQLException e) {
            System.out.println("getAllComment By articleId failed");
            e.printStackTrace();
        }
        return  null;
    }
}
