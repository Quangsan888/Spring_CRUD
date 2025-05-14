package com.quangsan.fpt.vn.controller;

import com.quangsan.fpt.vn.DTO.StudentDTO;
import com.quangsan.fpt.vn.entity.Student;
import com.quangsan.fpt.vn.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController {
  private  final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    ResponseEntity<?>   createStudent(@RequestBody Student student){

      return  studentService.createStudent(student);
    }

    @GetMapping("/listStudent")
    ResponseEntity<List<Student>> getAllStudents(){

      return  studentService.getAllStudents();
    }

     @GetMapping("/getStudent/{id}")
     ResponseEntity<?> getStudentById(@PathVariable int id){

      return  studentService.getStudentById(id);
     }

    @PutMapping("/update/{id}")
  ResponseEntity<?> updateStudent(@PathVariable int id,@RequestBody StudentDTO student){


      return  studentService.updateStudent(id,student);
    }
}
