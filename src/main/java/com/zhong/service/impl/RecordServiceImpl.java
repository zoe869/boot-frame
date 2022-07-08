package com.zhong.service.impl;


import com.zhong.entity.Menu;
import com.zhong.entity.Record;
import com.zhong.repository.RecordRepository;
import com.zhong.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Override
    public List findAll() {
        return recordRepository.findAll();
    }

    @Override
    public Record findById(Integer recordId) {
        return recordRepository.findbyRecordId(recordId);
    }

    @Override
    public void deleteById(Integer id) {
        recordRepository.deleteByRecordId(id);
    }

    @Override
    public Record update(Record record) {
        record.setUpdateDate(new Date());
        return recordRepository.saveAndFlush(record);
    }

    @Override
    public Record save(Record record) {
        return null;
    }
}
