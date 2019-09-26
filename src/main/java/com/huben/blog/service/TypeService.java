package com.huben.blog.service;

import com.huben.blog.dao.ArticleDao;
import com.huben.blog.dao.TypeDao;
import com.huben.blog.exception.MyException;
import com.huben.blog.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author koishi
 */
@Service
public class TypeService {
    @Autowired
    private TypeDao typeDao;
    @Autowired
    private ArticleDao articleDao;

    public List<Type> listAll() {
        return typeDao.listAll();
    }

    public void save(String name, int sort) {
        Type type = new Type();
        type.setName(name);
        type.setSort(sort);

        typeDao.save(type);
    }

    public void update(int id, String name, int sort) {
        Type type = new Type();
        type.setId(id);
        type.setName(name);
        type.setSort(sort);

        typeDao.update(type);
    }

    public void delete(int[] ids) throws MyException {
        int count = articleDao.countByTypeId(ids);
        if (count>0){
            throw new MyException("选中分类下还有文章, 不可删除");
        }

        articleDao.deleteByTypeId(ids);
        typeDao.delete(ids);
    }
}
