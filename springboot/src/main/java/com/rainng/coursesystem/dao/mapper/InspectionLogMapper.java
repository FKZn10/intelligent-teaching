package com.rainng.coursesystem.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainng.coursesystem.model.entity.InspectionLogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 质检记录表的数据通讯员
 */
@Mapper
@Repository
public interface InspectionLogMapper extends BaseMapper<InspectionLogEntity> {
}