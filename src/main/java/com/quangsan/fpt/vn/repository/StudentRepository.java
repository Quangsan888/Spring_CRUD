package com.quangsan.fpt.vn.repository;

import com.quangsan.fpt.vn.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    boolean existsByName(String name);
}
