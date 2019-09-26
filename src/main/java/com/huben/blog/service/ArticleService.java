package com.huben.blog.service;

import com.huben.blog.dao.ArticleDao;
import com.huben.blog.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author koishi
 */
@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;

    public List<Article> listAll(Map params) {
        return articleDao.listAll(params);
    }

    public Article selectById(String id) {
        return articleDao.selectById(Integer.parseInt(id));
    }

    public void save(Article article) {
        articleDao.save(article);
    }

    public void update(Article article) {
        articleDao.update(article);
    }

    public void remove(int[] ids) {
        articleDao.remove(ids);
    }

    public void cancel(int[] ids) {
        articleDao.cancel(ids);
    }

    public void delete(int[] ids) {
        articleDao.delete(ids);
    }

}
