package com.rainng.coursesystem.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

/**
 * 质检记录实体类
 * 对应数据库表: inspection_log
 */
@Data
@TableName("inspection_log")
public class InspectionLogEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    // 产品流水追踪码/条形码
    private String traceCode;

    // 识别到的产品型号
    private String productModel;

    // 是否存在缺陷: 0-否(false), 1-是(true)
    private Boolean isDamaged;

    // 缺陷类型(破损/污渍/褶皱)
    private String damageType;

    // 位置是否正确: 0-歪了(false), 1-正确(true)
    private Boolean isPositionCorrect;

    // 最终判定结果: PASS / FAIL
    private String finalResult;

    // 抓拍图片的存储地址
    private String imageUrl;

    // 检测时间
    private Date checkTime;
}