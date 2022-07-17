package com.zhong.service.impl;

import com.zhong.entity.Privilege;
import com.zhong.repository.PrivilegeRepository;
import com.zhong.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {


    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Override
    public List<Privilege> getPrivilegeByRoleid(int roleid) {
        return privilegeRepository.findAllByRoleId(roleid);
    }


}
