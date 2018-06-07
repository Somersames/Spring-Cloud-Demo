package com.somersmaes.dao;

import com.somersmaes.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CommentDao {

    /**
     * 查询出某一个物品下的评论
     * @param GoodId
     * @return
     */
    List<Map<Object,Object>> queryCommentsByGoodId(@Param("GoodId") int GoodId);

    /**
     * 插入新的评论
     * @param comment
     * @return
     */
    int insertNewComment(Comment comment);

    /**
     * 删除某一个评论
     * @param commentId
     * @return
     */
    int deleteComment(@Param("commentId") int commentId);
}
