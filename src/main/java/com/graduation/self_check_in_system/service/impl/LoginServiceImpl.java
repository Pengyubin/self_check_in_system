package com.graduation.self_check_in_system.service.impl;

import com.graduation.self_check_in_system.WebSecurityConfig;
import com.graduation.self_check_in_system.mapper.StudentMapper;
import com.graduation.self_check_in_system.modal.Student;
import com.graduation.self_check_in_system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getAll() {
        return studentMapper.getAll();
    }

    @Override
    public Student getStudentByAdm_num(String adm_num) {
        return studentMapper.getStudentByAdm_num(adm_num);
    }

    @Override
    public boolean passwordIsNull(String adm_num) {
        String password = studentMapper.getPasswordByAdm_num(adm_num);
        if("".equals(password) || password == null){
            return true;
        }
        return false;
    }

    //判断是否已经报到
    @Override
    public boolean idAdmiss(String adm_num) {

        return false;
    }

    //登录验证
    @Override
    public boolean loginVerify(Student student,HttpSession session) {
        String adm_num = student.getAdm_num();
        String password = student.getPassword();

        Student studentFromDB = studentMapper.getStudentByAdm_num(adm_num);
        if (studentFromDB.getPassword().equals(password)){
            //验证通过设置Session
            session.setAttribute(WebSecurityConfig.SESSION_KEY,studentFromDB.getUsername());
            session.setAttribute("statue",student.getStatue());
            return true;
        }
        if(studentFromDB.getPassword() == null || "".equals(studentFromDB.getPassword())){
            if (password.equals(studentFromDB.getID_num().substring(12))){
                //验证通过设置Session
                session.setAttribute(WebSecurityConfig.SESSION_KEY,studentFromDB.getUsername());
                session.setAttribute("statue",student.getStatue());
                return true;
            }
        }

        return false;
    }

    //获取登录的姓名
    @Override
    public String getLoginName(HttpServletRequest request) {
        if(request.getSession().getAttribute("loginName") != null){
            System.out.println(request.getSession().getAttribute("loginName"));
            return request.getSession().getAttribute("loginName").toString();
        }

        return null;
    }
}
