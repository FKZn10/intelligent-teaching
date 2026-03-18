package com.rainng.coursesystem.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainng.coursesystem.model.entity.ProductStandardEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 产品标准表的数据通讯员
 */
@Mapper
@Repository
public interface ProductStandardMapper extends BaseMapper<ProductStandardEntity> {
    // 只要继承了 BaseMapper，MyBatis-Plus 已经帮你写好了几十种增删改查方法，这里什么都不用写！
}