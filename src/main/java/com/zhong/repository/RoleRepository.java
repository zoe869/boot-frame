package com.zhong.repository;

import com.zhong.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    Optional<Role> findById(Integer roleId);

    void deleteById(Integer roleId);
}
