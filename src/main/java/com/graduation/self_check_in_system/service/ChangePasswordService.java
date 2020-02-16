package com.graduation.self_check_in_system.service;

import com.graduation.self_check_in_system.mapper.StudentMapper;
import com.graduation.self_check_in_system.modal.Student;
import org.springframework.beans.factory.annotation.Autowired;

public interface ChangePasswordService {
    boolean isExist(Student check_info);
}
