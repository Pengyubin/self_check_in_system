package com.graduation.self_check_in_system.modal;


public class Student {
    //录取编号
    private String adm_num;
    //身份证号
    private String ID_num;
    //姓名
    private String username;
    //密码
    private String password;
    //报到状态
    private Integer statue;
    //学院
    private String college_code;
    //专业
    private String profession_code;

    public String getAdm_num() {
        return adm_num;
    }

    public void setAdm_num(String adm_num) {
        this.adm_num = adm_num;
    }

    public String getID_num() {
        return ID_num;
    }

    public void setID_num(String ID_num) {
        this.ID_num = ID_num;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatue() {
        return statue;
    }

    public void setStatue(Integer statue) {
        this.statue = statue;
    }

    public String getCollege_code() {
        return college_code;
    }

    public void setCollege_code(String college_code) {
        this.college_code = college_code;
    }

    public String getProfession_code() {
        return profession_code;
    }

    public void setProfession_code(String profession_code) {
        this.profession_code = profession_code;
    }

    @Override
    public String toString() {
        return "Student{" +
                "adm_num='" + adm_num + '\'' +
                ", ID_num='" + ID_num + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", statue=" + statue +
                ", college_code='" + college_code + '\'' +
                ", profession_code='" + profession_code + '\'' +
                '}';
    }
}

