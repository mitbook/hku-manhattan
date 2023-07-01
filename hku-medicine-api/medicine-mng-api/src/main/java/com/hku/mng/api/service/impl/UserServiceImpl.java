package com.hku.mng.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hku.common.core.util.JwtUtil;
import com.hku.common.core.util.MD5Util;
import com.hku.mng.api.entity.User;
import com.hku.mng.api.mapper.UserMapper;
import com.hku.mng.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Set;

/**
 * @author pengzhengfa
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Value("${spring.tokenExpireTime}")
    private String expireTime;

    @Override
    public String login(User user) {
        String token = "";
        if (!StringUtils.isEmpty(user)) {
            String userName = user.getUserName();
            String password = user.getPassword();
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_name", userName);
            queryWrapper.eq("password", password);
            User dbUser = userMapper.selectOne(queryWrapper);
            if (!ObjectUtils.isEmpty(dbUser)) {
                token = JwtUtil.createToken(userName, Long.parseLong(expireTime));
            }
        }
        return token;
    }

    @Override
    public User getUserByUsername(String userName) {
        return userMapper.selectOne(new QueryWrapper<User>().eq("userName", userName));
    }

    @Override
    public Set<String> getUserRoles(String userName) {
        // 查询用户角色
        return userMapper.getUserRoles(userName);
    }

    @Override
    public Set<String> getUserPermissions(String userName) {
        // 查询用户权限
        return userMapper.getUserPermissions(userName);
    }

    @Override
    public void createUser(User user) {
        try {
            if (!StringUtils.isEmpty(user)){
                String password = user.getPassword();
                String md5Password = MD5Util.md5(password);
                user.setPassword(md5Password);
                userMapper.insert(user);
            }
        }catch (Exception e){
            log.error("新增用户异常:{}",e);
        }
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userMapper.deleteById(userId);
    }
}