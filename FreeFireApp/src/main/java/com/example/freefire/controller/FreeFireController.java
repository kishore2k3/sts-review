package com.example.freefire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.freefire.model.FreeFire;
import com.example.freefire.model.Tournament;
import com.example.freefire.service.FreeFireService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
public class FreeFireController {
	@Autowired
	FreeFireService ffservice;
	
	@Operation(summary = "Execute this method")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful"),
			@ApiResponse(responseCode = "401", description = "Invalid credentials"),
			@ApiResponse(responseCode = "404", description = "Path not found") })
	@ResponseStatus(HttpStatus.CREATED)
	
	@GetMapping("/getData")
	public List<FreeFire> getData()
	{
		return ffservice.getData();
	}
	@GetMapping(value="/sortData/{field}")
	public List<FreeFire> sortData(@PathVariable("field") String field)
	{
		return ffservice.sortData(field);
	}
	
	@PostMapping("/postData")
	public FreeFire postData(@RequestBody FreeFire f)
	{
		return ffservice.postData(f);
	}
	
	@GetMapping("/pageData/{offset}/{noofrecords}")
	public Page<FreeFire> pagingFF(@PathVariable("offset") int offset,@PathVariable("noofrecords") int noOfRecords)
	{
		return ffservice.pagingFF(offset,noOfRecords);
	}
	@GetMapping("/pageDataList/{offset}/{noofrecords}")
	public List<FreeFire> pagingByList(@PathVariable("offset") int offset,@PathVariable("noofrecords") int noOfRecords)
	{
		return ffservice.pagingByList(offset,noOfRecords);
	}
	@GetMapping("/pageDataAsc/{offset}/{noofrecords}/{field}")
	public List<FreeFire> pagingByAsc(@PathVariable("offset") int offset,@PathVariable("noofrecords") int noOfRecords,@PathVariable("field") String field)
	{
		return ffservice.pagingByAsc(offset,noOfRecords,field);
	}
	@GetMapping("/pageDataDesc/{offset}/{noofrecords}/{field}")
	public List<FreeFire> pagingByDesc(@PathVariable("offset") int offset,@PathVariable("noofrecords") int noOfRecords,@PathVariable("field") String field)
	{
		return ffservice.pagingByDesc(offset,noOfRecords,field);
	}
	
	@Operation(summary = "To get Data's of server only")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful"),
			@ApiResponse(responseCode = "401", description = "Invalid credentials"),
			@ApiResponse(responseCode = "404", description = "Path not found") })
	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping("/getdata/{field}")
	public List<FreeFire> getDataByField(@PathVariable("field") String field)
	{
		return ffservice.getDataByField(field);
	}
	
	
	@Operation(summary = "To get Data's of server with Starting words")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful"),
			@ApiResponse(responseCode = "401", description = "Invalid credentials"),
			@ApiResponse(responseCode = "404", description = "Path not found") })
	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping("/getdataByPrefix")
	public List<FreeFire> getDataByPrefix(@RequestParam String field)
	{
		return ffservice.getDataByPrefix(field);
	}
	
	@Operation(summary = "To get Data's of server with ending words")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful"),
			@ApiResponse(responseCode = "401", description = "Invalid credentials"),
			@ApiResponse(responseCode = "404", description = "Path not found") })
	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping("/getdataBySuffix")
	public List<FreeFire> getDataBySuffix(@RequestParam String field)
	{
		return ffservice.getDataBySuffix(field);
	}
	
	@Operation(summary = "To get Data's by name and server using RequestParam")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful"),
			@ApiResponse(responseCode = "401", description = "Invalid credentials"),
			@ApiResponse(responseCode = "404", description = "Path not found") })
	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping("/queryData")
	public List<FreeFire> getDataByQuery(@RequestParam String name,@RequestParam String server)
	{
		return ffservice.getDataByPosPara(name,server);
	}
	
	@Operation(summary = "To get Data's by name and server using RequestParam")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful"),
			@ApiResponse(responseCode = "401", description = "Invalid credentials"),
			@ApiResponse(responseCode = "404", description = "Path not found") })
	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping("/queryDataName")
	public List<FreeFire> getDataByPName(@RequestParam String name,@RequestParam String server)
	{
		return ffservice.getDataByNamePara(name,server);
	}
	
	@Operation(summary = "Delete Data's using Query in FreeFire")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful"),
			@ApiResponse(responseCode = "401", description = "Invalid credentials"),
			@ApiResponse(responseCode = "404", description = "Path not found") })
	@ResponseStatus(HttpStatus.CREATED)
	@DeleteMapping("/deleteDataQuery")
	public String deleteDataQuery(@RequestParam String name)
	{
		int result = ffservice.deleteDataQuery(name);
		if(result>0)
		{
			return "Record is deleted";
		}
		else 
		{
			return "Problem occured while deleting or no records found";
		}
	}
	
	@Operation(summary = "To Updata name and elite in FreeFire with Id using RequestParam")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful"),
			@ApiResponse(responseCode = "401", description = "Invalid credentials"),
			@ApiResponse(responseCode = "404", description = "Path not found") })
	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping("/updateFreeFire")
	public int updateFreeFire(@RequestParam String name,@RequestParam String elite,@RequestParam String id)
	{
		return ffservice.updateFreeFire(name,elite,id);
	}
	
	@Operation(summary = "To Get Data's in FreeFire with Elite using RequestParam")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful"),
			@ApiResponse(responseCode = "401", description = "Invalid credentials"),
			@ApiResponse(responseCode = "404", description = "Path not found") })
	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping("/getDataFreeFire")
	public List<FreeFire> getDataFreeFire(@RequestParam String elite)
	{
		return ffservice.getDataFreeFire(elite);
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Operation(summary = "To Get Data's Of Tournament")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful"),
			@ApiResponse(responseCode = "401", description = "Invalid credentials"),
			@ApiResponse(responseCode = "404", description = "Path not found") })
	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping("/getDataTournament")
	public List<Tournament> getDataTournament()
	{
		return ffservice.getDataTournament();
	}
	
	@Operation(summary = "Save Data's on tournament")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful"),
			@ApiResponse(responseCode = "401", description = "Invalid credentials"),
			@ApiResponse(responseCode = "404", description = "Path not found") })
	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping("/saveDataTournament")
	public Tournament saveDataTournament(@RequestBody Tournament data)
	{
		return ffservice.saveDataTournament(data);
	}
	
}
