package com.mhp.service.impl.admin;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.mhp.result.PageResult;
import com.mhp.service.admin.ArchiveService;
import com.mhp.vo.admin.MhArchiveVO;

import org.springframework.beans.factory.annotation.Autowired;

import com.mhp.dto.admin.ArchivePageQueryDTO;
import com.mhp.entity.MhArchive;
import com.mhp.mapper.admin.ArchiveMapper;

import java.util.List;
import com.github.pagehelper.Page;


@Service
public class ArchiveServiceImpl implements ArchiveService {
    @Autowired
    private ArchiveMapper archiveMapper;
    /**
     * 分页查询用户档案
     * @param archivePageQueryDTO 分页查询参数
     * @return 分页结果
     */
    @Override
    public PageResult pageQuery(ArchivePageQueryDTO archivePageQueryDTO) {
        PageHelper.startPage(archivePageQueryDTO.getPage(),archivePageQueryDTO.getPageSize());
        Page<MhArchive> page = archiveMapper.pageQuery(archivePageQueryDTO);
        Long total = page.getTotal();
        List<MhArchive> records = page.getResult();
        return new PageResult(total,records);
    }
    
    /**
     * 根据档案ID查询档案详情
     * @param archiveId 档案ID
     * @return 档案详情
     */
    @Override
    public MhArchive selectById(Long id) {
        return archiveMapper.selectById(id);
    }
    /**
     * 根据学号查询档案详情
     * @param studentId 学生ID
     * @return 档案详情
     */
    @Override
    public MhArchiveVO selectByStudentId(Long studentId) {
        return archiveMapper.selectByStudentId(studentId);
    }

    /**
     * 更新档案
     * @param mhArchive 档案信息
     * @return
     */
    @Override
    public void update(MhArchive mhArchive) {
        archiveMapper.update(mhArchive);
    }
}
