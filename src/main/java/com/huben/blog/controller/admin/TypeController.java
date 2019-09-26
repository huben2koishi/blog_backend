package com.huben.blog.controller.admin;

import com.huben.blog.exception.MyException;
import com.huben.blog.pojo.Result;
import com.huben.blog.pojo.Type;
import com.huben.blog.service.TypeService;
import com.huben.blog.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author koishi
 */
@Controller
@RequestMapping("admin/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list() {
        return "admin/type";
    }

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public Result listType() {
        List<Type> typeList = typeService.listAll();
        return Result.success("").add("typeList",typeList);
    }

    @ResponseBody
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public Result save(@RequestParam("ids") String[] ids, @RequestParam("names") String[] names, @RequestParam("sorts") int[] sorts) {
        for (int i = 0; i < names.length; i++) {
            if (ids.length == 0 || StringUtil.isEmpty(ids[i])) {
                typeService.save(names[i], sorts[i]);
            } else {
                typeService.update(Integer.parseInt(ids[i]), names[i], sorts[i]);
            }
        }

        return Result.success("保存成功");
    }

    @RequestMapping("delete")
    @ResponseBody
    public Result delete(int[] ids) throws MyException {
        typeService.delete(ids);

        return Result.success("删除成功");
    }
}
