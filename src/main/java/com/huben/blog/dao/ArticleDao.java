package com.huben.blog.dao;

import com.huben.blog.pojo.Article;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author koishi
 */
@Repository
public interface ArticleDao {
    List<Article> listAll(Map params);

    Article selectById(int id);

    void save(Article article);

    void update(Article article);

    void remove(int[] ids);

    void cancel(int[] ids);

    void delete(int[] id);

    int countByTypeId(int[] ids);

    void deleteByTypeId(int[] ids);
}
