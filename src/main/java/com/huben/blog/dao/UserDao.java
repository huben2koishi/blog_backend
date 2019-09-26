package com.huben.blog.dao;

import com.huben.blog.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author koishi
 */
@Repository
public interface UserDao {
    User checkUser(User user);
}
