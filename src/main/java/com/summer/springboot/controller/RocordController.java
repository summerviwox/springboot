package com.summer.springboot.controller;

import com.summer.springboot.mapper.RecordMapper;
import com.summer.springboot.model.Record;
import com.summer.springboot.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/record")
public class RocordController {

    @Autowired
    RecordService recordService;

    @GetMapping("/selectByPrimaryKey")
    public Record getRecord(Integer id){
        return recordService.selectByPrimaryKey(id);
    }

}
