package com.xiaofeng.mybatisplus.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.xiaofeng.mybatisplus.entity.Dept;
import com.xiaofeng.mybatisplus.mapper.DeptMapper;
import com.xiaofeng.mybatisplus.service.IDeptService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xiaofeng.mybatisplus.vo.DeptVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzj
 * @since 2019-03-29
 */
@Service
@Log4j2
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Resource
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        List<Dept> depts = deptMapper.selectList(new EntityWrapper<Dept>());
        return depts;
    }

    @Override
    public Page<Dept> page(){
        Page<Dept> deptPage = super.selectPage(new Page<Dept>(1, 10));
        return deptPage;
    }

    @Override
    public List<DeptVO> getDeptVOByDeptId(Integer deptId) {
        return deptMapper.getDeptVOByDeptId(deptId);
    }
}
