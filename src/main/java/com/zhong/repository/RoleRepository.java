package com.zhong.repository;

import com.zhong.entity.Menu;
import com.zhong.entity.Record;
import com.zhong.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findbyRoleId(Integer roleId);

    Role deleteByRoleId(Integer roleId);
}
