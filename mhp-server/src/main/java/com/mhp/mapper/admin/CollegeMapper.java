package com.mhp.mapper.admin;

import org.apache.ibatis.annotations.Mapper;
import com.mhp.entity.SysCollege;
import java.util.List;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CollegeMapper{

    /**
     * 分页查询学院
     * @param collegePageQueryDTO
     * @return
     */
    @Select("select * from sys_college")
    List<SysCollege> list();
}
