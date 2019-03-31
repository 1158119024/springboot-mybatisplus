package com.xiaofeng.mybatisplus.mapper;

import com.xiaofeng.mybatisplus.entity.Dept;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xiaofeng.mybatisplus.vo.DeptVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lzj
 * @since 2019-03-29
 */
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {

    List<DeptVO> getDeptVOByDeptId(Integer deptId);

    List<Dept> getList();
}
