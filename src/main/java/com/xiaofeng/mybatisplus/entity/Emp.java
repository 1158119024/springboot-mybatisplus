package com.xiaofeng.mybatisplus.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lzj
 * @since 2019-03-29
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Accessors(chain=true)
@ApiModel("员工模型")
public class Emp extends Model<Emp> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("员工id")
    private Integer empId;

    @ApiModelProperty("员工名称")
    private String empName;

    @ApiModelProperty("部门id")
    private Integer deptId;

    @Override
    protected Serializable pkVal() {
        return this.empId;
    }

}
