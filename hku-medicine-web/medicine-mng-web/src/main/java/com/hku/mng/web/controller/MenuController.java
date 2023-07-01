package com.hku.mng.web.controller;

import com.hku.mng.api.entity.Menu;
import com.hku.mng.api.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author pengzhengfa
 */
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/menus",method = RequestMethod.POST)
    public void menus(@RequestBody Menu menu) {
        menuService.getMenus(menu);
    }

    @RequestMapping(value = "/createMenu",method = RequestMethod.POST)
    public void createMenu(@RequestBody Menu menu) {
        menuService.createMenu(menu);
    }
    @RequestMapping(value = "/updateMenu",method = RequestMethod.POST)
    public void updateMenu(@RequestBody Menu menu) {
        menuService.updateMenu(menu);
    }
    @PostMapping("/deleteMenu")
    @RequestMapping(value = "/deleteMenu",method = RequestMethod.POST)
    public void deleteMenu(@PathVariable Long menuId) {
        menuService.deleteMenu(menuId);
    }
    @RequestMapping(value = "/allMenus",method = RequestMethod.GET)
    public List<Menu> allMenus() {
        return menuService.getAllMenus();
    }
}
