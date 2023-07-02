package com.hku.mng.api.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author pengzhengfa
 */
@Data
@TableName("user")
public class User {

    @TableField(value = "id")
    private Long id;

    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "id")
    private String password;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "email")
    private String email;

    @TableField(value = "job")
    private String job;


    @TableField(value = "gender")
    private String gender;

    /**
     * 0:禁用,1:启用
     */
    @TableField(value = "status")
    private Integer status;

    @TableField(value = "create_time")
    private String createTime;

    @TableField(value = "update_time")
    private String updateTime;

    /**
     * 0:未删除,1:删除
     */
    @TableField(value = "is_delete")
    private Integer isDelete;
}
