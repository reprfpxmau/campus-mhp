package com.mhp.mapper;

import com.github.pagehelper.Page;
import com.mhp.dto.UserPageQueryDTO;
import com.mhp.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import com.mhp.vo.UserPageQueryVO;
import com.mhp.vo.UserVO;
import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 分页查询用户
     * @param userPageQueryDTO
     * @return
     */
    Page<UserPageQueryVO> pageQuery(UserPageQueryDTO userPageQueryDTO);

    /**
     * 新增用户
     * @param sysUser
     * @return
     */
    void insert(SysUser sysUser);

    /**
     * 修改用户
     * @param sysUser
     * @return
     */
    void update(SysUser sysUser);

    /**
     * 根据用户ID查询用户详情
     * @param userId
     * @return
     */
    UserVO selectByUserId(Long userId);

    /**
     * 根据选择列表查询是否有启用用户
     * @param ids
     * @return
     */
    Long countByIds(List<Long> ids);
    /**
     * 删除用户
     * @param ids
     * @return
     */
    void deleteBatch(List<Long> ids);
}
