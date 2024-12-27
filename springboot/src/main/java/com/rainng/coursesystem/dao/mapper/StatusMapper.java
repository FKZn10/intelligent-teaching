package com.rainng.coursesystem.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainng.coursesystem.model.entity.StatusEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @Author Chen
 * @Date 2024/12/27 01:46
 */
@Mapper
public interface StatusMapper extends BaseMapper<StatusEntity> {

    @Update("update rc_status set student = #{status}")
    void updateStudentStatus(@Param("status") Boolean status);

    @Select("select student from rc_status")
    Boolean getStudentStatus();

    @Update("update rc_status set teacher = #{status}")
    void updateTeacherStatus(@Param("status") Boolean status);

    @Select("select teacher from rc_status")
    Boolean getTeacherStatus();
}
