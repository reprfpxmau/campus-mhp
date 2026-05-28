package com.mhp.mapper;

import com.mhp.vo.WarnPageQueryVO;
import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import com.mhp.dto.WarnPageQueryDTO;

@Mapper
public interface WarnMapper {
    /**
     * 分页查询预警事件
     * @param warnPageQueryDTO 分页查询参数
     * @return 分页结果
     */
    Page<WarnPageQueryVO> pageQuery(WarnPageQueryDTO warnPageQueryDTO);
}
