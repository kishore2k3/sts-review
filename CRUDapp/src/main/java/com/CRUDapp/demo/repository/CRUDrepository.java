package com.CRUDapp.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.CRUDapp.demo.model.Student;


public interface CRUDrepository extends JpaRepository<Student,Integer> {
	@Query("select s from Student s where s.dept=?1")
	List<Student> getStudentData(String data);

}
