package com.huben.blog.dao;

import com.huben.blog.pojo.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author koishi
 */
@Repository
public interface TypeDao {
    List<Type> listAll();

    void save(Type type);

    void update(Type type);

    void delete(int[] ids);
}
