package com.xiaofeng.mybatisplus.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;



import com.baomidou.mybatisplus.annotations.Version;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lzj
 * @since 2019-03-31
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Accessors(chain = true)
@ApiModel("学生模型")
public class Student extends Model<Student> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("学生id")
    private Integer id;

    @ApiModelProperty("学生年龄")
    private Integer age;

    @ApiModelProperty("学生名称")
    private String studentName;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
