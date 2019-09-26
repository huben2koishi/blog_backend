package com.huben.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huben.blog.pojo.Article;
import com.huben.blog.pojo.Result;
import com.huben.blog.service.ArticleService;
import com.huben.blog.service.TypeService;
import com.huben.blog.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author koishi
 */
@Controller
@RequestMapping("admin/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private TypeService typeService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "admin/article";
    }

    @ResponseBody
    @RequestMapping(value = "list" ,method = RequestMethod.POST)
    public Result listArticle(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                              @RequestParam(value = "typeId", required = false) String typeId,
                              @RequestParam(value = "startDate", required = false) String startDate,
                              @RequestParam(value = "endDate", required = false) String endDate,
                              @RequestParam(value = "keyword", required = false) String keyword){
        Map<String, String> params = new HashMap<>(4);
        params.put("typeId", typeId);
        params.put("startDate", startDate);
        params.put("endDate", endDate);
        if (!StringUtil.isEmpty(keyword)) {
            params.put("keyword", keyword.trim());
        }
        params.put("status", "1");

        PageHelper.startPage(pageNum, pageSize);
        List<Article> articleList = articleService.listAll(params);
        PageInfo<Article> pageInfo = new PageInfo<>(articleList);
        return Result.success("").add("pageInfo",pageInfo).add("typeList",typeService.listAll()).add("typeId",typeId);
    }

    @RequestMapping(value = "recycle",method = RequestMethod.GET)
    public String recycle(){
        return "admin/recycle";
    }

    @ResponseBody
    @RequestMapping(value = "recycle",method = RequestMethod.POST)
    public Result recycleArticle(
                          @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                          @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> params = new HashMap<>(1);
        params.put("status", "0");

        PageHelper.startPage(pageNum, pageSize);
        List<Article> articles = articleService.listAll(params);
        PageInfo<Article> pageInfo = new PageInfo<>(articles);

        return Result.success("").add("pageInfo",pageInfo);
    }

    @RequestMapping(value = "edit",method = RequestMethod.GET)
    public String edit() {
        return "admin/edit";
    }

    @ResponseBody
    @RequestMapping(value = "edit",method = RequestMethod.POST)
    public Result editArticle(@RequestParam(required = false, value = "id") String id) {
        Result result = Result.success("");
        if (!StringUtil.isEmpty(id)) {
            result.add("article", articleService.selectById(id));
        }

        result.add("typeList", typeService.listAll());
        return result;
    }

    @ResponseBody
    @RequestMapping("save")
    public Result save(Article article) {
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        article.setUpdateTime(now);
        if (article.getId() == 0) {
            articleService.save(article);
        } else {
            articleService.update(article);
        }

        return Result.success("保存成功");
    }
    @RequestMapping("remove")
    @ResponseBody
    public Result remove(int[] ids) {
        articleService.remove(ids);

        return Result.success("已移入回收站");
    }

    @RequestMapping("cancel")
    @ResponseBody
    public Result cancel(int[] ids) {
        articleService.cancel(ids);

        return Result.success("已恢复");
    }

    @RequestMapping("delete")
    @ResponseBody
    public Result delete(int[] ids) {
        articleService.delete(ids);

        return Result.success("已彻底删除");
    }

}
