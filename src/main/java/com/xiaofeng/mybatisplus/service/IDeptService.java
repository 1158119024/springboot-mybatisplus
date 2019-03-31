package com.xiaofeng.mybatisplus.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.xiaofeng.mybatisplus.entity.Dept;
import com.baomidou.mybatisplus.service.IService;
import com.xiaofeng.mybatisplus.vo.DeptVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lzj
 * @since 2019-03-29
 */
public interface IDeptService extends IService<Dept> {

    List<Dept> list();

    Page<Dept> page();

    List<DeptVO> getDeptVOByDeptId(Integer deptId);
}
