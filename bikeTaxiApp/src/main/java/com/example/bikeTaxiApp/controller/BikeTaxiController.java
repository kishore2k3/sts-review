package com.example.bikeTaxiApp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bikeTaxiApp.model.BikeTaxi;
import com.example.bikeTaxiApp.model.BikeTaxiLogin;
import com.example.bikeTaxiApp.service.BikeTaxiService;

@RestController
public class BikeTaxiController {
	@Autowired
	BikeTaxiService BTService;
	@GetMapping("/getLoginData")
	public List<BikeTaxiLogin> getLogin()
	{
		return BTService.getLoginData();
	}
	@PostMapping("/login")
	public String Login(@RequestBody Map<String,String> data)
	{
		String userEmail = data.get("email");
		String userPassword = data.get("password");
		return BTService.Login(userEmail,userPassword);
	}
	@PostMapping("/addUser")
	public BikeTaxiLogin addUser(@RequestBody BikeTaxiLogin data)
	{
		return BTService.addUser(data);
	}
	
	@GetMapping("/getData")
	public List<BikeTaxi> getData()
	{
		return BTService.getData();
	}
	@PostMapping("/putData")
	public BikeTaxi putData(@RequestBody BikeTaxi data)
	{
		return BTService.putData(data);
	}
	
	@GetMapping("/sortDataAsc/{field}")
	public List<BikeTaxi> sortDataByAsc(@PathVariable("field") String data)
	{
		return BTService.sortDataByAsc(data);
	}
	@GetMapping("/sortDataDesc/{field}")
	public List<BikeTaxi> sortDataByDesc(@PathVariable("field") String data)
	{
		return BTService.sortDataByDesc(data);
	}
	@GetMapping("/pageData/{offset}/{noofrecords}")
	public Page<BikeTaxi> pageData(@PathVariable("offset") int pageNo,@PathVariable("noofrecords") int noOfRecords)
	{
		return BTService.pageData(pageNo,noOfRecords);
	}
	@GetMapping("/pageListData/{offset}/{noofrecords}")
	public List<BikeTaxi> pageListData(@PathVariable("offset") int pageNo,@PathVariable("noofrecords") int noOfRecords)
	{
		return BTService.pageListData(pageNo,noOfRecords);
	}
	@GetMapping("/pageListDataAsc/{offset}/{noofrecords}/{field}")
	public List<BikeTaxi> pageListDataAsc(@PathVariable("offset") int pageNo,@PathVariable("noofrecords") int noOfRecords,@PathVariable("field") String data)
	{
		return BTService.pageListDataAsc(pageNo,noOfRecords,data);
	}
	@GetMapping("/pageListDataDesc/{offset}/{noofrecords}/{field}")
	public List<BikeTaxi> pageListDataDesc(@PathVariable("offset") int pageNo,@PathVariable("noofrecords") int noOfRecords,@PathVariable("field") String data)
	{
		return BTService.pageListDataDesc(pageNo,noOfRecords,data);
	}
}
