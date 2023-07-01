package com.hku.mng.web.controller;

import com.hku.mng.api.entity.Role;
import com.hku.mng.api.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author pengzhengfa
 */
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/createRole",method = RequestMethod.POST)
    public void createRole(@RequestBody Role role) {
        roleService.createRole(role);
    }


    @RequestMapping(value = "/updateRole",method = RequestMethod.POST)
    public void updateRole(@RequestBody Role role) {
        roleService.updateRole(role);
    }

    @RequestMapping(value = "/deleteRole",method = RequestMethod.POST)
    public void deleteRole(@PathVariable Long roleId) {
        roleService.deleteRole(roleId);
    }

    @RequestMapping(value = "/allRoles",method = RequestMethod.POST)
    public List<Role> allRoles() {
        return roleService.getAllRoles();
    }
}
