package com.zhong.service.impl;


import com.zhong.entity.Menu;
import com.zhong.entity.Role;
import com.zhong.repository.RoleRepository;
import com.zhong.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author
 * @since 2022-07-05
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Integer roleId) {
        return roleRepository.findbyRoleId(roleId);
    }

    @Override
    public void deleteById(Integer id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role update(Role role) {
        role.setUpdateDate(new Date());
        return roleRepository.saveAndFlush(role);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
