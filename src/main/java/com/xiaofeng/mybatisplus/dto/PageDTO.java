package com.xiaofeng.mybatisplus.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Auther: 晓枫
 * @Date: 2019/3/30 22:06
 * @Description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Accessors(chain=true)
@ApiModel("分页入参数据模型")
public class PageDTO {
    @ApiModelProperty("当前页")
    private Integer currentPage = 1;
    @ApiModelProperty("每页大小")
    private Integer pageSize = 10;

}
