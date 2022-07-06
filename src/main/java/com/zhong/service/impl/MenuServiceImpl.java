package com.zhong.service.impl;

import com.zhong.repository.MenuRepository;
import com.zhong.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author
 * @since 2022-07-05
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuRepository menuRepository;

}
