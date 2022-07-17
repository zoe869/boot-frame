package com.zhong.repository;

import com.zhong.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer> {

    Record findByRecordId(Integer recordId);

    Record deleteByRecordId(Integer recordId);
}
