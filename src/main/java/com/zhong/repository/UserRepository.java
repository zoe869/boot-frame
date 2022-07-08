package com.zhong.repository;

import com.zhong.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsernameAndPassword(String username, String password);

    User findByUserId(Integer id);

    void deleteByUserId(Integer id);
}
