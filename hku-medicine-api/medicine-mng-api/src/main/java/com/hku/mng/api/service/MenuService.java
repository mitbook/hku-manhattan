package com.hku.mng.api.service;

import com.hku.mng.api.entity.Menu;

import java.util.List;

/**
 * @author pengzhengfa
 */
public interface MenuService {

    List<Menu> getMenus(Menu menu);

    Integer createMenu(Menu menu);

    Integer updateMenu(Menu menu);

    Integer deleteMenu(Long menuId);

    List<Menu> getAllMenus();
}
