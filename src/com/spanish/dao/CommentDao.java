package com.spanish.dao;

import com.spanish.bean.Comment;

import java.util.List;

public interface CommentDao {

    List<Comment> findAllComments();

    void addComment(Comment comment);

    List<Comment> getAllCommentByArticleId(int articleId);



}
