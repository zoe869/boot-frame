package com.zhong.service;

import com.zhong.entity.Menu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuwen
 * @since 2022-07-05
 */
public interface MenuService{

    List findAll();

    Menu findById(Integer menuId);

    void deleteById(Integer id);

    Menu update(Menu menu);

    Menu save(Menu menu);
}
