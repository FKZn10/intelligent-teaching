package com.rainng.coursesystem.service;

import com.rainng.coursesystem.dao.mapper.InspectionLogMapper;
import com.rainng.coursesystem.model.entity.InspectionLogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service // 告诉 Spring Boot 这是一个业务经理，把它管理起来
public class InspectionService {

    @Autowired // 自动把刚才写的通讯员（Mapper）给请过来
    private InspectionLogMapper inspectionLogMapper;

    /**
     * 这是一个保存质检记录的方法，将来供 Controller 调用
     */
    public void saveInspectionResult(String model, Boolean isDamaged, String damageType, Boolean positionCorrect) {
        // 1. 创建一个空白的实体类替身
        InspectionLogEntity log = new InspectionLogEntity();

        // 2. 把传进来的参数塞进去
        log.setProductModel(model);
        log.setIsDamaged(isDamaged);
        log.setDamageType(damageType);
        log.setIsPositionCorrect(positionCorrect);
        log.setCheckTime(new Date());

        // 3. 业务逻辑判断：如果有破损，或者位置不对，最终结果就是 FAIL
        if (isDamaged || !positionCorrect) {
            log.setFinalResult("FAIL");
        } else {
            log.setFinalResult("PASS");
        }

        // 4. 让通讯员去保存到数据库
        inspectionLogMapper.insert(log);

        System.out.println("成功保存了一条质检记录，判定结果为：" + log.getFinalResult());
    }
}