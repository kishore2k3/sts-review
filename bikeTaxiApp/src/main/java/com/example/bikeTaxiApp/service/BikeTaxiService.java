package com.example.bikeTaxiApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.bikeTaxiApp.model.BikeTaxi;
import com.example.bikeTaxiApp.model.BikeTaxiLogin;
import com.example.bikeTaxiApp.repository.BikeTaxiLoginRepository;
import com.example.bikeTaxiApp.repository.BikeTaxiRepository;

@Service
public class BikeTaxiService {
	@Autowired
	BikeTaxiLoginRepository BTLRep;
	
	@Autowired
	BikeTaxiRepository BTRep;

	public String Login(String email, String password) {
		try {
		BikeTaxiLogin userEmail = BTLRep.findById(email).get();
		if(userEmail == null)
		{
			return "Account isn't found or email incorrect";
		}
		else 
		{
			if((userEmail.getPassword()).equals(password))
			{
				return "Login Successfull";
			}
			else
			{
				return "Login Unsuccessfull! Check email and password";
			}
		}
		}
		catch(Exception e)
		{
			return "Login Unsuccessfull! Check email and password";
		}
	}

	public List<BikeTaxiLogin> getLoginData() {
		return BTLRep.findAll();
	}

	public BikeTaxiLogin addUser(BikeTaxiLogin data) {
		return BTLRep.save(data);
	}

	public List<BikeTaxi> getData() {
		return BTRep.findAll();
	}

	public BikeTaxi putData(BikeTaxi data) {
		return BTRep.save(data);
	}

	public List<BikeTaxi> sortDataByAsc(String field) {
		return BTRep.findAll(Sort.by(field));
	}
	public List<BikeTaxi> sortDataByDesc(String field) {
		return BTRep.findAll(Sort.by(Direction.DESC,field));
	}

	public Page<BikeTaxi> pageData(int pageNo, int noOfRecords) {
		Pageable data=PageRequest.of(pageNo, noOfRecords);
		Page<BikeTaxi> pData=BTRep.findAll(data);
		return pData;
	}
	
	public List<BikeTaxi> pageListData(int pageNo, int noOfRecords) {
		Pageable data=PageRequest.of(pageNo, noOfRecords);
		Page<BikeTaxi> pData=BTRep.findAll(data);
		return pData.getContent();
	}
	public List<BikeTaxi> pageListDataAsc(int pageNo, int noOfRecords,String field) {
		Pageable data=PageRequest.of(pageNo, noOfRecords).withSort(Sort.by(field));
		Page<BikeTaxi> pData=BTRep.findAll(data);
		return pData.getContent();
	}
	public List<BikeTaxi> pageListDataDesc(int pageNo, int noOfRecords,String field) {
		Pageable data=PageRequest.of(pageNo, noOfRecords).withSort(Sort.by(Direction.DESC,field));
		Page<BikeTaxi> pData=BTRep.findAll(data);
		return pData.getContent();
	}
}
