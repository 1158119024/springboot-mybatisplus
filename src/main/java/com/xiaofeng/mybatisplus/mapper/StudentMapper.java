package com.xiaofeng.mybatisplus.mapper;

import com.xiaofeng.mybatisplus.entity.Student;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lzj
 * @since 2019-03-31
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
