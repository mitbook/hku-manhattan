package com.hku.mng.api.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author pengzhengfa
 */
@Data
@TableName("menu")
public class Menu {

    @TableField(value = "id")
    private Long id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "url")
    private String url;

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
