package com.application.sms.controller;

import com.application.sms.entity.Student;
import com.application.sms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        // Create student object to hold stident form data
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model){
        // get student from db by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        // now save updated student object
        studentService.updateStudent(existingStudent);

        return "redirect:/students";
    }
}