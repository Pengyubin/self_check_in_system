package com.graduation.self_check_in_system.service.impl;

import com.graduation.self_check_in_system.mapper.StudentMapper;
import com.graduation.self_check_in_system.modal.Student;
import com.graduation.self_check_in_system.service.ChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: self_check_in_system
 * @description:
 * @author: peng yu bin
 * @create: 2020-02-16 20:50
 */
@Service
public class ChangePasswordServiceImpl implements ChangePasswordService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public boolean isExist(Student check_info) {
        Student findInDB = studentMapper.getStudentByAdm_num(check_info.getAdm_num());
        //判断数据库中是否存在对应录取编号的学生
        if (findInDB == null){
            return false;
        }
        //判断输入的身份证号是否与数据库中的身份证号对应
        if (!findInDB.getID_num().equals(check_info.getID_num())){
            return false;
        }
        return true;
    }
}
