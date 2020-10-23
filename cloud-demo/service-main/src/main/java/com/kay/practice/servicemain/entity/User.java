package com.kay.practice.servicemain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 用户实体类
 * @author Kay
 * @date 2020-10-23
 */
@Data
@ApiModel("用户")
public class User {
    /**
     * ID
     */
    @ApiModelProperty("id")
    private Integer id;
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;
    /**
     * 盐
     */
    @ApiModelProperty("盐")
    private String salt;
    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String name;
    /**
     * 用户简介
     */
    @ApiModelProperty("用户简介")
    private String description;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date gmtCreate;
    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date gmtModified;
}
