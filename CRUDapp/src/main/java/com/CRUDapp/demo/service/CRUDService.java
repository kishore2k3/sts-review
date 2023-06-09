package com.CRUDapp.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRUDapp.demo.model.Student;
import com.CRUDapp.demo.repository.CRUDrepository;

@Service
public class CRUDService {
	@Autowired
	CRUDrepository studRep;
	public Student postData(Student e)
	{
		return studRep.save(e);
	}
	public List<Student> getAllStudent()
	{
		List<Student> studData=studRep.findAll();
		return studData;
	}
	public void deleteData(int i)
	{
		studRep.deleteById(i);
	}
	public Student getById(Integer s)
	{
		return studRep.findById(s).get();
	}
	public List<Student> getStudentData(String data) {
		return studRep.getStudentData(data);
	}
}
