package com.mhp.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import com.mhp.entity.MhArchive;
import com.mhp.dto.ArchivePageQueryDTO;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ArchiveMapper {
    /**
     * 分页查询用户档案
     * @param archivePageQueryDTO 分页查询参数
     * @return 分页结果
     */
    Page<MhArchive> pageQuery(ArchivePageQueryDTO archivePageQueryDTO);

    /**
     * 根据档案ID查询档案详情
     * @param id 档案ID
     * @return 档案详情
     */
    @Select("select * from mh_archive where archive_id = #{id}")
    MhArchive selectById(Long id);

    /**
     * 根据学号查询档案详情
     * @param studentId 学生ID
     * @return 档案详情
     */
    @Select("select * from mh_archive where student_id = #{studentId}")
    MhArchive selectByStudentId(Long studentId);

}
