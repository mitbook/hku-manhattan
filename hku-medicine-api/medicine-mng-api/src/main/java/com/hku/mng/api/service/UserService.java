package com.hku.mng.api.service;

import com.hku.mng.api.entity.User;

import java.util.Set;

/**
 * @author pengzhengfa
 */
public interface UserService {
    String login(User user);

    User getUserByUsername(String userName);

    Set<String> getUserRoles(String userName);

    Set<String> getUserPermissions(String userName);

    void createUser(User user);

    Integer updateUser(User user);

    void deleteUser(Long userId);
}
