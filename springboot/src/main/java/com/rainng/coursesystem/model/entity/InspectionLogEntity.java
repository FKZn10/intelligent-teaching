package com.rainng.coursesystem.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

@Data
@TableName("inspection_log") // 绑定我们刚刚建的数据库表
public class InspectionLogEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String model;          // 产品型号
    private Boolean isDamaged;     // 是否破损 (MyBatis会自动把 1/0 映射为 true/false)
    private Boolean positionCorrect;// 位置是否正确
    private String finalResult;    // PASS or FAIL
    private Date createTime;       // 检测时间
}