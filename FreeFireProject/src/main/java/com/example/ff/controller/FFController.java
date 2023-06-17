package com.example.ff.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ff.model.LoginForm;
import com.example.ff.model.RegistrationForm;
import com.example.ff.model.Tournament;
import com.example.ff.service.FFService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin("http://localhost:3000/")
public class FFController {
	@Autowired
	FFService ser;
	@Operation(summary = "Execute this method")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful"),
			@ApiResponse(responseCode = "401", description = "Invalid credentials"),
			@ApiResponse(responseCode = "404", description = "Path not found") })
	@ResponseStatus(HttpStatus.CREATED)
	
	@PostMapping("/postDataRegistration/{email}")
	public String postDataRegistration(@RequestBody RegistrationForm data,@PathVariable("email") String e)
	{
		return ser.postDataRegistration(data,e);
	}
	@PostMapping("/verifyDataLogin")
	public String verifyDataLogin(@RequestBody LoginForm data)
	{
		String userEmail = data.getEmail();
		String userPassword = data.getPassword();
		return ser.verifyDataLogin(userEmail,userPassword);
	}
	@GetMapping("/getData/{email}")
	public Optional<RegistrationForm> getDataByEmail(@PathVariable("email") String e)
	{
		return ser.getData(e);
	}
	@GetMapping("/getDataRegistration")
	public List<RegistrationForm> getDataRegistraton()
	{
		return ser.getDataRegistration();
	}
	@DeleteMapping("/deleteData/{id}")
	public String deleteData(@PathVariable("id") int n)
	{
		return ser.deleteData(n);
	}
	@PutMapping("/putData/{email}")
	public String putData(@RequestBody RegistrationForm data,@PathVariable("email") String no)
	{
		return ser.putData(data,no);
	}
	@GetMapping("/sortData/{field}")
	public List<RegistrationForm> sortData(@PathVariable("field") String f)
	{
		return ser.sortData(f);
	}
	@GetMapping("/sortDescData/{field}")
	public List<RegistrationForm> sortDescData(@PathVariable("field") String f)
	{
		return ser.sortDescData(f);
	}
	@GetMapping("/pageData/{pageno}/{noofrecords}")
	public Page<RegistrationForm> pageData(@PathVariable("pageno") int a,@PathVariable("noofrecords") int b)
	{
		return ser.pageData(a,b);
	}
	@GetMapping("/pageListData/{pageno}/{noofrecords}")
	public List<RegistrationForm> pageListData(@PathVariable("pageno") int a,@PathVariable("noofrecords") int b)
	{
		return ser.pageListData(a,b);
	}
	@GetMapping("/pageDataAsc/{offset}/{field}")
	public List<RegistrationForm> pagingByAsc(@PathVariable("offset") int a,@PathVariable("field") String b)
	{
		return ser.pagingByAsc(a-1,10,b);
	}
	@GetMapping("/pageDataDesc/{offset}/{field}")
	public List<RegistrationForm> pagingByDesc(@PathVariable("offset") int a,@PathVariable("field") String b)
	{
		return ser.pagingByDesc(a-1,10,b);
	}
	@GetMapping("/getDataByName/{name}")
	public List<RegistrationForm> getDataByName(@PathVariable("name") String a)
	{
		return ser.getDataByName(a);
	}
	@GetMapping("/getDataByNameStart/{name}")
	public List<RegistrationForm> getDataByNameStart(@PathVariable("name") String a)
	{
		return ser.getDataByNameStart(a);
	}
	@GetMapping("/getDataByNameEnd/{name}")
	public List<RegistrationForm> getDataByNameEnd(@PathVariable("name") String a)
	{
		return ser.getDataByNameEnd(a);
	}
	@GetMapping("/getRegionAndLevel/{region}/{level}")
	public List<RegistrationForm> getRegionAndLevel(@PathVariable("region") String a,@PathVariable("level") int b)
	{
		return ser.getRegionAndLevel(a,b);
	}
	@DeleteMapping("/deleteDataQuery")
	public String deleteDataQuery(@RequestParam String name)
	{
		int result = ser.deleteDataQuery(name);
		if(result>0)
		{
			return "Record is deleted";
		}
		else 
		{
			return "Problem occured while deleting or no records found";
		}
	}
	@PutMapping("/updateFreeFire")
	public String updateFreeFire(@RequestParam String name,@RequestParam String elite,@RequestParam String id)
	{
		int result = ser.updateFreeFire(name, elite, id);
		if(result>0)
		{
			return "Record is Updated";
		}
		else 
		{
			return "Problem occured while Updating or no records found";
		}
	}
	@GetMapping("/getDataTournament")
	public List<Tournament> getDataTournament()
	{
		return ser.getDataTournament();
	}
	@PutMapping("/saveDataTournament")
	public Tournament saveDataTournament(@RequestBody Tournament data)
	{
		return ser.saveDataTournament(data);
	}
}