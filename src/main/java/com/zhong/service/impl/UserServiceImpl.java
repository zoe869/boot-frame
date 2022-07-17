package com.zhong.service.impl;


import com.zhong.entity.User;
import com.zhong.repository.UserRepository;
import com.zhong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
@Transactional
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
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(User res) {
        return userRepository.save(res);
    }

    @Override
    public List<User> findAll() {
        System.out.println("userRepository.userRepository.findAll()"+userRepository.findAll());
        return userRepository.findAll();
    }

    @Override
    public void deleteByUid(Integer userId) {
        userRepository.deleteByUserId(userId);
    }

    @Override
    public User update(User user) {
        user.setUpdateDate(new Date());
        return userRepository.saveAndFlush(user);
    }

    @Override
    public boolean userIsExisted(User user) {
        User res = userRepository.findByUsername(user.getUsername());
        return res!=null?true:false;
    }


}
