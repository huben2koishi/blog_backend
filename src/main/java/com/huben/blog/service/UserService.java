package com.huben.blog.service;


import com.huben.blog.dao.UserDao;
import com.huben.blog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author koishi
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User checkUser(User user){
        return userDao.checkUser(user);
    }

}
