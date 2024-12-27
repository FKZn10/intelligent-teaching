package com.rainng.coursesystem.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import javax.validation.constraints.NotNull;

@TableName("rc_status")
@Data
public class StatusEntity {

    @NotNull
    @TableField("student")
    private Boolean student;

    @NotNull
    @TableField("teacher")
    private Boolean teacher;
}
