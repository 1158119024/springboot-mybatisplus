package com.xiaofeng.mybatisplus.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sun.tools.internal.xjc.Language;
import com.xiaofeng.mybatisplus.config.JSONResult;
import com.xiaofeng.mybatisplus.entity.Dept;
import com.xiaofeng.mybatisplus.service.IDeptService;
import com.xiaofeng.mybatisplus.dto.PageDTO;
import com.xiaofeng.mybatisplus.vo.DeptVO;
import io.swagger.annotations.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzj
 * @since 2019-03-29
 */
@RestController
@RequestMapping("/dept")
@Api(value = "部门操作", tags = "部门操作")
@Log4j2
public class DeptController {

    @Autowired
    private IDeptService iDeptService;

    @ApiImplicitParams({
        @ApiImplicitParam(name = "deptId", value = "部门id, 不用传"),
        @ApiImplicitParam(name = "deptName", value = "部门名称", required = true)
    })
    @PostMapping("/insert")
    public JSONResult insert(Dept dept){
        boolean bool = iDeptService.insert(dept);
        return bool ? JSONResult.success(null): JSONResult.fail(null);
    }

    @ApiOperation(value="根据deptId删除部门数据", notes="根据deptId删除部门数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "deptId", value = "部门id", required = true),
    })
    @PostMapping("/delete")
    public JSONResult delete(Integer deptId){
        boolean bool = iDeptService.deleteById(deptId);
        return bool ? JSONResult.success(null): JSONResult.fail(null);
    }

    @ApiOperation(value = "根据deptId修改部门名称等信息", notes = "根据deptId修改部门名称等信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "deptId", value = "部门id", required = true),
        @ApiImplicitParam(name = "deptName", value = "部门名称", required = true)
    })
    @PostMapping(value = "/update")
    public JSONResult update(Dept dept){
        boolean bool = iDeptService.updateById(dept);
        return bool ? JSONResult.success(null): JSONResult.fail(null);
    }

    @ApiOperation(value="获取部门列表信息", notes="获取所有的部门列表信息")
    @GetMapping(value = "/list", headers = "app-version=1.0")
    public JSONResult<List<Dept>> list(){
        log.info("-------------app-version=1");
        List<Dept> list = iDeptService.list();
        return JSONResult.success(list);
    }

    @ApiOperation(value="获取部门列表信息-2", notes="获取所有的部门列表信息-2")
    @GetMapping(value = "/list", headers = "app-version=2.0")
    public JSONResult<List<Dept>> list2(){
        log.info("-------------app-version=2");
        List<Dept> list = iDeptService.list();
        return JSONResult.success(list);
    }

    @ApiOperation(value="分页获取部门信息", notes="分页获取部门信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "currentPage", value = "当前页", defaultValue = "1"),
        @ApiImplicitParam(name = "pageSize", value = "每页大小", defaultValue = "10")
    })
    @GetMapping("/page")
    public JSONResult<Page<Dept>> page(PageDTO pageDTO){
        Page<Dept> deptPage = new Page<>(pageDTO.getCurrentPage(), pageDTO.getPageSize());
        deptPage = iDeptService.selectPage(deptPage);
        System.out.println(deptPage);
        return JSONResult.success(deptPage);
    }

    @ApiOperation(value = "获取指定部门", notes = "根据部门id获取指定的部门")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "deptId", value = "部门deptId", required = true)
    })
    @GetMapping("/getDeptById")
    public JSONResult<Dept> getDeptById(@RequestParam Integer deptId){
        Dept dept = iDeptService.selectById(deptId);
        return JSONResult.success(dept);
    }

    @ApiOperation(value = "根据部门名称模糊查询部门信息", notes = "根据部门名称模糊查询部门信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "deptName", value = "部门名称", required = true)
    })
    @GetMapping("/getDeptByName")
    public JSONResult<Dept> getDeptByName(@RequestParam String deptName){
        Dept dept = iDeptService.selectOne(new EntityWrapper<Dept>().like("deptName", deptName));
        return JSONResult.success(dept);
    }

    @ApiModelProperty(value = "根据部门id查询部门及员工信息", notes = "根据部门id查询部门及员工信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "deptId", value = "部门id", required = true)
    })
    @GetMapping(value = "/getDeptVOByDeptId")
    public JSONResult<List<DeptVO>> getDeptVOByDeptId(Integer deptId, @RequestHeader Language language){
        List<DeptVO> deptVOByDeptId = iDeptService.getDeptVOByDeptId(deptId);
        language.name();
        return JSONResult.success(deptVOByDeptId);
    }


    @PostMapping("/actEumList")
    @ApiOperation(value = "简单枚举类型",notes = "递归参数-enum-简单枚举",tags = {"枚举测试"})
    public JSONResult actEumList(Language language){
        JSONResult r=new JSONResult<>();
        r.setMsg(language.name());
        return r;
    }
}
