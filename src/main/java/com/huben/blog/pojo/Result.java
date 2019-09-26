package com.huben.blog.pojo;

import com.huben.blog.utils.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author koishi
 */
public class Result {
    /**
     * 成功 1, 失败 0
     */
    private int code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    public Result add(String key, Object value){
        this.data.put(key,value);
        return this;
    }

    public static Result success(String msg) {
        Result result = new Result();
        result.setCode(1);
        if (StringUtil.isEmpty(msg)) {
            result.setMessage("请求成功");
        } else {
            result.setMessage(msg);
        }
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(0);
        if (StringUtil.isEmpty(msg)) {
            result.setMessage("请求失败");
        } else {
            result.setMessage(msg);
        }
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
            "code=" + code +
            ", message='" + message + '\'' +
            ", data=" + data +
            '}';
    }
}
