package com.summer.springboot.mapper;

import com.summer.springboot.model.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


public interface RecordMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);
}