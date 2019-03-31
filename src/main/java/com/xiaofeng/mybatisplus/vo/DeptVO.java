package com.xiaofeng.mybatisplus.vo;

import com.xiaofeng.mybatisplus.entity.Emp;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Auther: 晓枫
 * @Date: 2019/3/31 10:34
 * @Description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Accessors(chain=true)
@ApiModel("部门与员工VO模型")
public class DeptVO {

    @ApiModelProperty("部门id")
    private Integer deptId;

    @ApiModelProperty("部门名称")
    private String deptName;

    @ApiModelProperty("该部门下员工列表")
    private List<Emp> empList;
}
