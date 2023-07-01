package com.hku.mng.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hku.mng.api.entity.Menu;
import com.hku.mng.api.mapper.MenuMapper;
import com.hku.mng.api.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getMenus(Menu menu) {
        Long id = menu.getId();
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        return menuMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public Integer createMenu(Menu menu) {
        return menuMapper.insert(menu);
    }

    @Override
    @Transactional
    public Integer updateMenu(Menu menu) {
        return menuMapper.updateById(menu);
    }

    @Override
    @Transactional
    public Integer deleteMenu(Long menuId) {
        return menuMapper.deleteById(menuId);
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.selectList(null);
    }
}
