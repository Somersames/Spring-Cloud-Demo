package com.somersames.dao;

import com.somersames.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface CommentDao {

    /**
     * 查询出某一个物品下的评论
     * @param goodId
     * @return
     */
    List<Map<Object,Object>> queryCommentsByGoodId(@Param("goodId") String goodId);

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
