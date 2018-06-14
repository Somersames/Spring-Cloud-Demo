package com.somersames.service;

import com.somersames.dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author szh
 * @create 2018-06-14 14:31
 **/
@Service
public class CommentDaoService {
    @Autowired
    CommentDao commentDao;

}
