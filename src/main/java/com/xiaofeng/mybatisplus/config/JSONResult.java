package com.xiaofeng.mybatisplus.config;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.activerecord.Model;
import com.xiaofeng.mybatisplus.entity.Dept;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @Auther: 晓枫
 * @Date: 2019/3/29 23:13
 * @Description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Accessors(chain=true)
@ApiModel("通用响应数据")
public class JSONResult<T> implements Serializable {
    @ApiModelProperty("响应编码")
    private int code;
    @ApiModelProperty("响应消息")
    private String msg;
    @ApiModelProperty("响应数据")
    private T data;


//    public JSONResult<T> success(T data){
//        return this.setCode(200).setMsg("操作成功").setData(data);
//    }

//    public JSONResult<T> fail(T data){
//        return this.setCode(500).setMsg("操作失败").setData(data);
//    }

    public static<T> JSONResult<T> fail(T data) {
        return new JSONResult<>(500, "操作失败", data);
    }

    public static<T> JSONResult<T> success(T data) {
        String[] appVersion = {"1.0", "2.0"};
        return new JSONResult<>(200, "操作成功", data);
    }
}
