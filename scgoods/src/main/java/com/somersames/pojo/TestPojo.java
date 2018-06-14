package com.somersames.pojo;

import java.io.Serializable;

/**
 * @author szh
 * @create 2018-06-12 21:01
 **/
public class TestPojo implements Serializable {
    private String name;
    private String star;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }
}
