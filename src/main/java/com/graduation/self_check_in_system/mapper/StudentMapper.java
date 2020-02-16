package com.graduation.self_check_in_system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.graduation.self_check_in_system.modal.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "studentMapper")
public interface StudentMapper{
    @Select("select * from admission")
    @Results({
            @Result(column = "adm_num", property = "adm_num"),
            @Result(column = "id_num", property = "ID_num"),
            @Result(column = "stuName", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "statue",property = "statue")
    })
    List<Student> getAll();

    @Select("select * from admission where adm_num=#{adm_num}")
    @Results({
            @Result(column = "adm_num", property = "adm_num"),
            @Result(column = "id_num", property = "ID_num"),
            @Result(column = "stuName", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "statue",property = "statue")
    })
    Student getStudentByAdm_num(String adm_num);

    @Select("select password from admission where adm_num=#{adm_num}")
    String getPasswordByAdm_num(String adm_num);
}
