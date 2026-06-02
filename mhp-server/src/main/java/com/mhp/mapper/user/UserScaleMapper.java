package com.mhp.mapper.user;

import com.mhp.entity.PsyScale;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface UserScaleMapper {

    /**
     * 查询用户测试可用的测试项
     * @return 可用的测试项
     */
    @Select("select * from psy_scale where status = 1")
    List<PsyScale> scaleList();
}
