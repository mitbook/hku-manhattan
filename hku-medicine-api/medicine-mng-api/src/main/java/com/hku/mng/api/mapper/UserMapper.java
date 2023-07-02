package com.hku.mng.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hku.mng.api.entity.User;

import java.util.Set;

/**
 * @author pengzhengfa
 */
public interface UserMapper extends BaseMapper<User> {

    Set<String> getUserRoles(String userName);

    Set<String> getUserPermissions(String userName);
}
