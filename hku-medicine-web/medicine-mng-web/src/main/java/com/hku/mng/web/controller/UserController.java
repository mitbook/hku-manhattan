package com.hku.mng.web.controller;

import com.hku.common.core.base.Result;
import com.hku.mng.api.entity.User;
import com.hku.mng.api.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author pengzhengfa
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result<String> login(@RequestBody User user){
        return Result.success(userService.login(user));
    }
    @RequestMapping(value = "/createUser",method = RequestMethod.POST)
    public Result createUser(@RequestBody User user) {
        userService.createUser(user);
        return Result.success("创建用户成功");
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public Result updateUser(@RequestBody User user) {
        Integer updateUser = userService.updateUser(user);
        if (updateUser>1){
            return Result.success(updateUser,"用户信息更新成功");
        }
        return Result.failed("用户信息更新失败");
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
