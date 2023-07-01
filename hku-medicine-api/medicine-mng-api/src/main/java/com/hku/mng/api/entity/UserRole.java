package com.hku.mng.api.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author pengzhengfa
 */
@Data
@TableName("user_role")
public class UserRole {

    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "role_id")
    private Long roleId;

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
