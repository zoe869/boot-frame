package com.zhong.service;


import com.zhong.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuwen
 * @since 2022-07-05
 */
public interface UserService{

    User findByUsernameAndPassword(String username, String password);

    User findByUid(Integer id);
    User findByUsername(String username);

    User save(User res);

    List<User> findAll();

    void deleteByUid(Integer userId);

    User update(User user);

    boolean userIsExisted(User user);
}
