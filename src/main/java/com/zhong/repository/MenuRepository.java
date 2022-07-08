package com.zhong.repository;

import com.zhong.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    Menu findByMenuId(Integer menuId);

    Menu deleteByMenuId(Integer menuId);

}
