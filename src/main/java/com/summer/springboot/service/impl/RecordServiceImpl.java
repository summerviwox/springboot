package com.summer.springboot.service.impl;

import com.google.gson.Gson;
import com.summer.springboot.mapper.RecordMapper;
import com.summer.springboot.model.Record;
import com.summer.springboot.service.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("recordService")
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public Record selectByPrimaryKey(int id) {
        return recordMapper.selectByPrimaryKey(id);
    }
}
