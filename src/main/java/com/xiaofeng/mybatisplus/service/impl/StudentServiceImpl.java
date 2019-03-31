package com.xiaofeng.mybatisplus.service.impl;

import com.xiaofeng.mybatisplus.entity.Student;
import com.xiaofeng.mybatisplus.mapper.StudentMapper;
import com.xiaofeng.mybatisplus.service.IStudentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzj
 * @since 2019-03-31
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Resource
    private StudentMapper studentMapper;
}
