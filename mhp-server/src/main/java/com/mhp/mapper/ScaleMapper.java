package com.mhp.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import com.mhp.entity.PsyScale;
import com.mhp.dto.ScalePageQueryDTO;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ScaleMapper {
    /**
     * 分页查询心理量表
     * @param scalePageQueryDTO 分页查询参数
     * @return 分页结果
     */
    Page<PsyScale> pageQuery(ScalePageQueryDTO scalePageQueryDTO);

    /**
     * 新增心理量表
     * @param psyScale 心理量表
     */
    void insert(PsyScale psyScale);


    /**
     * 根据量表编码查询
     * @param scaleCode 量表编码
     * @return 量表
     */
    Integer selectByScaleCode(String scaleCode);

    /**
     * 更新心理量表
     * @param psyScale 心理量表
     */
    void update(PsyScale psyScale);
    /**
     * 获取量表状态
     * @param scaleId 量表ID
     * @return 量表状态
     */
    @Select("select status from psy_scale where scale_id = #{scaleId}")
    Integer selectStatusById(Long scaleId);
}