package com.rainng.coursesystem.manager;

import com.rainng.coursesystem.dao.mapper.StatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OptionManager extends BaseManager {

    @Autowired
    private StatusMapper statusMapper;

    public Boolean getAllowStudentSelect() {
        return statusMapper.getStudentStatus();
    }

    public void setAllowStudentSelect(Boolean status) {
        statusMapper.updateStudentStatus(status);
    }

    public Boolean getAllowTeacherGrade() {
        return statusMapper.getTeacherStatus();
    }

    public void setAllowTeacherGrade(Boolean status) {
        statusMapper.updateTeacherStatus(status);
    }
}
