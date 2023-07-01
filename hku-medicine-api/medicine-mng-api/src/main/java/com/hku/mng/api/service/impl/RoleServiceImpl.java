package com.hku.mng.api.service.impl;

import com.hku.mng.api.entity.Role;
import com.hku.mng.api.mapper.RoleMapper;
import com.hku.mng.api.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    @Transactional
    public void createRole(Role role) {
        roleMapper.insert(role);
    }

    @Override
    @Transactional
    public void updateRole(Role role) {
        roleMapper.updateById(role);
    }

    @Override
    @Transactional
    public void deleteRole(Long roleId) {
        roleMapper.deleteById(roleId);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleMapper.selectList(null);
    }
}
