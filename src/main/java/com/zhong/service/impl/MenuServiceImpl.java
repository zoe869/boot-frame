package com.zhong.service.impl;

import com.zhong.entity.Menu;
import com.zhong.repository.MenuRepository;
import com.zhong.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author
 * @since 2022-07-05
 */
@Transactional
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List findAll() {
        return menuRepository.findAll();
    }

    @Override
    public Menu findById(Integer menuId) {
        return menuRepository.findByMenuId(menuId);
    }

    @Override
    public void deleteById(Integer id) {
        menuRepository.deleteByMenuId(id);
    }

    @Override
    public Menu update(Menu menu) {
        return menuRepository.saveAndFlush(menu);
    }

    @Override
    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }
}
