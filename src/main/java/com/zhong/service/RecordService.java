package com.zhong.service;


import com.zhong.entity.Menu;
import com.zhong.entity.Record;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuwen
 * @since 2022-07-05
 */
public interface RecordService{

    List findAll();

    Record findById(Integer recordId);

    void deleteById(Integer id);

    Record update(Record record);

    Record save(Record record);
}
