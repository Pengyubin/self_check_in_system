package com.graduation.self_check_in_system.controller;

import com.graduation.self_check_in_system.modal.Student;
import com.graduation.self_check_in_system.service.ChangePasswordService;
import com.graduation.self_check_in_system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @program: self_check_in_system
 * @description:
 * @author: peng yu bin
 * @create: 2020-02-12 16:22
 */
@Controller
public class ChangePasswordController {
    @Autowired
    private ChangePasswordService changePasswordService;

    @PostMapping("/check")
    @ResponseBody
    public String check(@RequestBody Student check_info){
        System.out.println(check_info.toString());
        boolean isExist = changePasswordService.isExist(check_info);
        if(!isExist){
            return "false";
        }
        return "true";
    }
}
