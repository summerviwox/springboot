package com.summer.springboot.service;

import com.summer.springboot.model.Record;

import java.util.List;

public interface RecordService {

    Record selectByPrimaryKey(int id);
}
