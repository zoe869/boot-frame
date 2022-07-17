package com.zhong.service;

import com.zhong.entity.Role;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuwen
 * @since 2022-07-05
 */
public interface RoleService {

    List findAll();

    Role findById(Integer roleId);

    void deleteById(Integer id);

    Role update(Role role);

    Role save(Role role);
}
