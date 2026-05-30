package com.mhp.mapper;

import com.mhp.entity.SysClass;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ClassMapper {
    /**
     * 根据学院ID查询班级列表
     * @param collegeId 学院ID
     * @return 班级列表
     */
    List<SysClass> listByCollegeId(Long collegeId);
}
