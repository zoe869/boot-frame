package com.zhong.controller;

import com.zhong.entity.Record;
import com.zhong.entity.Role;
import com.zhong.service.RecordService;
import com.zhong.utils.SysResult;
import com.zhong.utils.SysResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author
 * @since 2022-07-05
 */
@RestController
public class RecordController {

    @Autowired
    private RecordService recordService;

    @GetMapping("/{roleId}")
    public SysResult findById(@PathVariable("roleId") Integer roleId){
        System.out.println("根据ID查找");
        return SysResultHandler.success(recordService.findById(roleId));
    }

    @DeleteMapping("/{userId}")
    public SysResult deleteById(@PathVariable("roleId") Integer roleId){
        System.out.println("deleteById");
        recordService.deleteById(roleId);
        return SysResultHandler.success();
    }

    @PutMapping("/{userId}")
    public SysResult update(@PathVariable("recordId") Integer recordId,@RequestBody Record record){
        Record res = recordService.findById(recordId);
        if (res == null) {
            return SysResultHandler.buildSysResult(404,"not user with id :"+recordId,null);
        }
        return SysResultHandler.success(recordService.update(record));
    }

    @PostMapping
    public SysResult add(@RequestBody Record record){
        return SysResultHandler.success(recordService.save(record));
    }
}
