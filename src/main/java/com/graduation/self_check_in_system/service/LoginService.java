package com.graduation.self_check_in_system.service;

import com.graduation.self_check_in_system.modal.Student;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


public interface LoginService {
    List<Student> getAll();
    //获取该生的身份信息
    Student getStudentByAdm_num(String adm_num);
    //判断该生是否设置了密码
    boolean passwordIsNull(String adm_num);

    boolean idAdmiss(String adm_num);

    String getLoginName(HttpServletRequest request);

    //密码验证
    boolean loginVerify(Student student, HttpSession session);
}
