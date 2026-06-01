package com.mhp.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.mhp.vo.CounselorPageQueryVO;
import java.util.List;

@Mapper
public interface CounselorMapper {
    /**
     * 查询咨询师列表
     * @return 咨询师列表
     */
    List<CounselorPageQueryVO> list();
}
