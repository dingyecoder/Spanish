package com.spanish.service;

import com.spanish.bean.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComment();

    List<Comment> getAllCommentByArticleId(int articleId);
}
