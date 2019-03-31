package com.xiaofeng.mybatisplus.web;


import com.alibaba.fastjson.JSON;
import com.xiaofeng.mybatisplus.config.JSONResult;
import com.xiaofeng.mybatisplus.entity.Dept;
import com.xiaofeng.mybatisplus.service.IDeptService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzj
 * @since 2019-03-29
 */
@Controller
@RequestMapping("/emp")
public class EmpController {

}
