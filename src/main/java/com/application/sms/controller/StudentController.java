package com.application.sms.controller;

import com.application.sms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        RedirectAttributes redirectAttributes) {

        // Check if the username and password match the "admin" credentials
        if ("admin".equals(username) && "admin".equals(password)) {
            // Redirect to the students page if login is successful
            return "redirect:/students";
        }

        // If the login is unsuccessful, set an error message and redirect to the login page
        redirectAttributes.addFlashAttribute("error", "Invalid username or password.");
        return "redirect:/"; // Redirect back to login page
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }
}