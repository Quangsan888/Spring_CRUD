package com.quangsan.fpt.vn.service;


import com.quangsan.fpt.vn.DTO.StudentDTO;
import com.quangsan.fpt.vn.entity.Student;
import com.quangsan.fpt.vn.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.net.ssl.SSLEngineResult;
import java.util.List;

@Service
public class StudentService {
   private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public ResponseEntity<?>  createStudent(Student student){
        if (studentRepository.existsByName(student.getName())) {
            // Trả về lỗi nếu sinh viên đã tồn tại
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User exists");
        }

      studentRepository.save(student);

        return  ResponseEntity.status(HttpStatus.OK).body(student);
    }

    public ResponseEntity<List<Student>> getAllStudents(){

        return    ResponseEntity.status(HttpStatus.OK).body(studentRepository.findAll());

    }

    public ResponseEntity<?> updateStudent(int id,StudentDTO studentRequest){
         Student student = studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student not found"));
        student.setName(studentRequest.getName());
        student.setGrade(studentRequest.getGrade());

        return  ResponseEntity.status(HttpStatus.OK).body(studentRepository.save(student));
    }


    public ResponseEntity<?> getStudentById(int id){
        if (!studentRepository.existsById(id)) {
            // Trả về lỗi nếu sinh viên không tồn tại
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        Student student = studentRepository.findById(id).orElseThrow(() ->  new RuntimeException("User not found"));
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

}
