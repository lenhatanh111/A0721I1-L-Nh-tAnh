package com.example.demo.dto;

import com.example.demo.model.GroupClass;
import com.example.demo.model.Teacher;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class StudentDto {
    private int id;
    @NotEmpty
    @NotBlank
    private String name;
    @NotEmpty
    @NotBlank
    private String project;
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",message = "sai định đạng email")
    private String email;
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$",message = "sai dinh dang sdt")
    private String phone;
    @NotEmpty
    @NotBlank
    private Teacher teacher;
    private GroupClass groupClass;
}
