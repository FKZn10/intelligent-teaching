package com.rainng.coursesystem.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

/**
 * 产品标准实体类
 * 对应数据库表: product_standard
 */
@Data
@TableName("product_standard")
public class ProductStandardEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    // 产品型号
    private String modelName;

    // 预设能效等级
    private Integer energyLevel;

    // 标准贴标位置X坐标
    private Double labelPositionX;

    // 标准贴标位置Y坐标
    private Double labelPositionY;

    // 创建时间
    private Date createTime;
}