package com.zhong.service;


import com.zhong.entity.Privilege;

import java.util.List;

public interface PrivilegeService {

    List<Privilege> getPrivilegeByRoleid(int roleid);

}
