package com.spanish.service.impl;

import com.spanish.bean.Comment;
import com.spanish.dao.CommentDao;
import com.spanish.dao.impl.CommentDaoImpl;
import com.spanish.service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    CommentDao commentDao = new CommentDaoImpl();
    @Override
    public List<Comment> getAllComment() {
        List<Comment> commentList = commentDao.findAllComments();
        return commentList;
    }

    @Override
    public List<Comment> getAllCommentByArticleId(int articleId) {
        return commentDao.getAllCommentByArticleId(articleId);
    }
}
