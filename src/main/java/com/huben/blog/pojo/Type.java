package com.huben.blog.pojo;

/**
 * @author koishi
 */
public class Type {
    private int id;
    private String name;
    private int sort;

    @Override
    public String toString() {
        return "Type{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", sort=" + sort +
            '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
