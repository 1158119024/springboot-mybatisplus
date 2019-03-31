package com.xiaofeng.mybatisplus.service.impl;

import com.xiaofeng.mybatisplus.entity.Emp;
import com.xiaofeng.mybatisplus.mapper.EmpMapper;
import com.xiaofeng.mybatisplus.service.IEmpService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzj
 * @since 2019-03-29
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {

}
