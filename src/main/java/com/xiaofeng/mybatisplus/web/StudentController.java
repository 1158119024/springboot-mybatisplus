package com.xiaofeng.mybatisplus.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.xiaofeng.mybatisplus.config.JSONResult;
import com.xiaofeng.mybatisplus.entity.Student;
import com.xiaofeng.mybatisplus.service.IStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzj
 * @since 2019-03-31
 */
@RestController
@Api(tags = "学生操作")
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @ApiOperation(value="获取学生列表信息", notes="获取所有的学生列表信息")
    @GetMapping("/list")
    public JSONResult<List<Student>> list(){
        List<Student> students = iStudentService.selectList(new EntityWrapper<Student>());
        return new JSONResult<List<Student>>().success(students);
    }
}
