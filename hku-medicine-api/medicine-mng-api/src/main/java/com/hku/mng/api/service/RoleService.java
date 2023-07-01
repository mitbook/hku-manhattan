package com.hku.mng.api.service;

import com.hku.mng.api.entity.Role;

import java.util.List;

/**
 * @author pengzhengfa
 */
public interface RoleService {

    void createRole(Role role);

    void updateRole(Role role);

    void deleteRole(Long roleId);

    List<Role> getAllRoles();
}
