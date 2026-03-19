package com.rainng.coursesystem.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainng.coursesystem.model.entity.InspectionLogEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface InspectionLogMapper extends BaseMapper<InspectionLogEntity> {
    // 只要继承了 BaseMapper，就自动拥有了 insert, select, delete 等方法，不用手写SQL！
}