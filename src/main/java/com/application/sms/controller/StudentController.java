package com.application.sms.controller;

import com.application.sms.service.StudentService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }
}