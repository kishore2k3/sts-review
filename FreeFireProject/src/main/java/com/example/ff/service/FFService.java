package com.example.ff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.ff.model.LoginForm;
import com.example.ff.model.RegistrationForm;
import com.example.ff.model.Tournament;
import com.example.ff.repository.LoginRepository;
import com.example.ff.repository.RegistrationRepository;
import com.example.ff.repository.TournamentRepository;

@Service
public class FFService {
	@Autowired
	RegistrationRepository regrep;
	
	@Autowired
	LoginRepository logrep;
	
	@Autowired
	TournamentRepository trep;

	public String postDataRegistration(RegistrationForm data, String e) {
		Optional<LoginForm> dta = logrep.findById(e);
		if(dta.isPresent())
		{
			return "Email Id is already Registered";
		}
		else
		{
			regrep.save(data);
			return "Registration Successfull";
		}
	}

	public String verifyDataLogin(String email, String password) {
		try {
			LoginForm userEmail = logrep.findById(email).get();
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
					return "Login Unsuccessfull! Incorrect Password";
				}
			}
			}
			catch(Exception e)
			{
				return "Login Unsuccessfull! Check email and password";
			}
	}

	public Optional<RegistrationForm> getData(String e) {
		int n = regrep.findId(e);
		return regrep.findById(n);
	}
	public List<RegistrationForm> getDataRegistration()
	{
		return regrep.findAll();
	}

	public String deleteData(int n) {
		Optional<RegistrationForm> dta = regrep.findById(n);
		if(dta.isPresent())
		{
			regrep.deleteById(n);
			return "Data Deleted Successfully";
		}
		else
		{
			return "Invalid Id";
		}
	}

	public String putData(RegistrationForm u, String email) {
		int no = regrep.findId(email);
		Optional<RegistrationForm> data=regrep.findById(no);
		if(data.isPresent())
		{
			regrep.save(u);
			return "Updated Successfully";
		}
		return "Unsuccessfull";
	}

	public List<RegistrationForm> sortData(String field) {
		return regrep.findAll(Sort.by(field));
	}
	public List<RegistrationForm> sortDescData(String field) {
		return regrep.findAll(Sort.by(Direction.DESC,field));
	}

	public Page<RegistrationForm> pageData(int a, int b) {
		Pageable paging = PageRequest.of(a, b);
		Page<RegistrationForm> data = regrep.findAll(paging);
		return data;
	}

	public List<RegistrationForm> pageListData(int a, int b) {
		Pageable paging = PageRequest.of(a, b);
		Page<RegistrationForm> data = regrep.findAll(paging);
		return data.getContent();
	}

	public List<RegistrationForm> pagingByAsc(int offset, int noOfRecords, String field) {
		Pageable paging = PageRequest.of(offset, noOfRecords).withSort(Sort.by(field));
		Page<RegistrationForm> data = regrep.findAll(paging);
		return data.getContent();
	}

	public List<RegistrationForm> pagingByDesc(int offset, int noOfRecords, String field) {
		Pageable paging = PageRequest.of(offset, noOfRecords).withSort(Sort.by(Direction.DESC,field));
		Page<RegistrationForm> data = regrep.findAll(paging);
		return data.getContent();
	}

	public List<RegistrationForm> getDataByName(String a) {
		return regrep.findByName(a);
	}

	public List<RegistrationForm> getDataByNameStart(String a) {
		return regrep.findByNameStartingWith(a);
	}

	public List<RegistrationForm> getDataByNameEnd(String a) {
		return regrep.findByNameEndingWith(a);
	}

	public List<RegistrationForm> getRegionAndLevel(String a, int b) {
		return regrep.findByRegionAndLevel(a, b);
	}

	public int deleteDataQuery(String name) {
		return regrep.deleteFreeFireByName(name);
	}

	public int updateFreeFire(String name, String elite, String id) {
		return regrep.updateFreeFire(name, elite, id);
	}
	public List<Tournament> getDataTournament() {
		return trep.findAll();
	}

	public Tournament saveDataTournament(Tournament data) {
		return trep.save(data);
	}
}