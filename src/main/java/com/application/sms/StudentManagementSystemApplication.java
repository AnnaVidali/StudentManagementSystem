package com.application.sms;

import com.application.sms.entity.Student;
import com.application.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementSystemApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
//        Student student1 = new Student("John", "Doe", "johndoe@gmail.com");
//        studentRepository.save(student1);
//
//        Student student2 = new Student("Chris", "Smith", "chrissmith@gmail.com");
//        studentRepository.save(student2);
//
//        Student student3 = new Student("Paul", "Nicols", "paulnicols@gmail.com");
//        studentRepository.save(student3);
//
//        Student student4 = new Student("Robert", "Williams", "robertwilliams@gmail.com");
//        studentRepository.save(student4);
//
//        studentRepository.deleteAll();
    }
}
