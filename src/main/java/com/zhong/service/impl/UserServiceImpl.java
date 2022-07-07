package com.zhong.service.impl;


import com.zhong.entity.User;
import com.zhong.repository.UserRepository;
import com.zhong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User findByUsernameAndPassword(String username, String password) {

        return userRepository.findByUsernameAndPassword(username,password);
    }

    @Override
    public User findByUid(Integer id) {
        return userRepository.findByUserId(id);
    }

    @Override
    public void save(User res) {
        userRepository.save(res);
    }

    @Override
    public List<User> findAll() {
        System.out.println("userRepository.userRepository.findAll()"+userRepository.findAll());
        return userRepository.findAll();
    }
}
