package com.rainng.coursesystem.service;

import com.rainng.coursesystem.dao.mapper.InspectionLogMapper;
import com.rainng.coursesystem.model.entity.InspectionLogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class InspectionService {

    @Autowired
    private InspectionLogMapper inspectionLogMapper;

    // 保存 Python 端传过来的质检数据
    public void saveInspectionResult(InspectionLogEntity logEntity) {
        // 根据业务规则：破损 或者 位置不对，最终结果就是 FAIL
        if (logEntity.getIsDamaged() || !logEntity.getPositionCorrect()) {
            logEntity.setFinalResult("FAIL");
        } else {
            logEntity.setFinalResult("PASS");
        }

        logEntity.setCreateTime(new Date()); // 自动打上当前时间戳

        // 插入数据库
        inspectionLogMapper.insert(logEntity);
    }
}