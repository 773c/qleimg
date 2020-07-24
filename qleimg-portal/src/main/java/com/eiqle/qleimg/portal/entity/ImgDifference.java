package com.eiqle.qleimg.portal.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 图像做差实体类
 */
public class ImgDifference implements Serializable{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "图像做差ID")
    private long id;

    @ApiModelProperty(value = "图像做差名称")
    private String name;

    @ApiModelProperty(value = "图像做差存储地址")
    private String filepath;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public String toString() {
        return "ImgDifference{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", filepath='" + filepath + '\'' +
                '}';
    }
}
