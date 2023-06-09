package com.CRUDapp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CRUDapp.demo.model.Student;
import com.CRUDapp.demo.service.CRUDService;

@RestController
public class CRUDController {
	@Autowired
	CRUDService studService;
	
	@PostMapping(value="/postdata")
	public Student postData(@RequestBody Student s)
	{
		return studService.postData(s);
	}
	
	@GetMapping(value="/getdata")
	public List<Student> getAllStudent()
	{
		List<Student> studData= studService.getAllStudent();
		return studData;
	}
	
	@PutMapping(value="/putdata")
	public Student updateStudent(@RequestBody Student e)
	{
		return studService.postData(e);
	}
	
	@DeleteMapping(value="/deletedata/{rollno}")
	public void deleteStudent(@PathVariable("rollno") int i)
	{
		studService.deleteData(i);
	}
	
	@GetMapping(value="/getdata/{rollno}")
	public Student getById(@PathVariable("rollno") int s)
	{
		return studService.getById(s);
	}
	@DeleteMapping("/getStudentData")
	public List<Student> getStudentData(@RequestParam String data)
	{
		return studService.getStudentData(data);
	}
}
