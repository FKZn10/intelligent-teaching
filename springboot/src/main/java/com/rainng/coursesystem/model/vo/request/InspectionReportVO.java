package com.rainng.coursesystem.model.vo.request;

import lombok.Data;

/**
 * 接收 Python 端质检结果的“快递单”
 */
@Data
public class InspectionReportVO {
    // 识别到的产品型号 (比如: "HA-100")
    private String productModel;

    // 是否存在缺陷: false-否, true-是
    private Boolean isDamaged;

    // 缺陷类型 (比如: "破损")
    private String damageType;

    // 位置是否正确: false-歪了, true-正确
    private Boolean isPositionCorrect;
}