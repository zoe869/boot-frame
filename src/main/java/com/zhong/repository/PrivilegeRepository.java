package com.zhong.repository;

import com.zhong.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {

    @Query(value = "SELECT * FROM sys_tbl_privilege WHERE role_id = ?1", nativeQuery = true)
    List<Privilege> findAllByRoleId(int roleid);
}
