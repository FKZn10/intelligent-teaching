package com.rainng.coursesystem.controller;

import com.rainng.coursesystem.model.entity.InspectionLogEntity;
import com.rainng.coursesystem.service.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/inspection")
public class InspectionController {

    @Autowired
    private InspectionService inspectionService;

    // 接收 Python 端发送的 POST 请求 (JSON 格式)
    @PostMapping("/report")
    public Map<String, Object> reportResult(@RequestBody InspectionLogEntity logEntity) {

        // 1. 调用 Service 处理并保存到数据库
        inspectionService.saveInspectionResult(logEntity);

        // 2. 抛弃原项目的 ResultVO，直接用原生的 Map 组装成功信息！
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("message", "检测数据上传成功！判定结果为: " + logEntity.getFinalResult());
        result.put("data", null);

        // 3. 返回 Map，Spring Boot 会自动把它变成 JSON
        return result;
    }
}