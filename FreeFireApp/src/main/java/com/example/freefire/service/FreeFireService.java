package com.example.freefire.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.freefire.model.FreeFire;
import com.example.freefire.model.Tournament;
import com.example.freefire.repository.FreeFireRepository;
import com.example.freefire.repository.TournamentRepository;

import jakarta.transaction.Transactional;

@Service
public class FreeFireService {
	//JPQL -> Java Persistence Query Language
	@Autowired
	FreeFireRepository ffrep;
	
	@Autowired
	TournamentRepository TRep;
	
	public List<FreeFire> getData() {
		return ffrep.findAll();
	}

	public FreeFire postData(FreeFire f) {
		return ffrep.save(f);
	}

	public List<FreeFire> sortData(String field) {
		return ffrep.findAll(Sort.by(Direction.DESC,field));
	}

	public Page<FreeFire> pagingFF(int offset, int noOfRecords) {
		Pageable paging=PageRequest.of(offset, noOfRecords);
		Page<FreeFire> pData=ffrep.findAll(paging);
		return pData;
	}
	public List<FreeFire> pagingByList(int offset, int noOfRecords) {
		Pageable paging=PageRequest.of(offset, noOfRecords);
		Page<FreeFire> pData=ffrep.findAll(paging);
		return pData.getContent();
	}

	public List<FreeFire> pagingByAsc(int offset, int noOfRecords, String field) {
		Pageable paging=PageRequest.of(offset, noOfRecords).withSort(Sort.by(field));
		Page<FreeFire> pData=ffrep.findAll(paging);
		return pData.getContent();
	}

	public List<FreeFire> pagingByDesc(int offset, int noOfRecords, String field) {
		Pageable paging=PageRequest.of(offset, noOfRecords).withSort(Sort.by(Direction.DESC,field));
		Page<FreeFire> pData=ffrep.findAll(paging);
		return pData.getContent();
	}

	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public List<FreeFire> getDataByField(String field) {
		return ffrep.findByRegion(field);
	}
	
	public List<FreeFire> getDataByPrefix(String field) {
		return ffrep.findByRegionStartingWith(field);
	}

	public List<FreeFire> getDataBySuffix(String field) {
		return ffrep.findByRegionEndingWith(field);
	}

	public List<FreeFire> getDataByPosPara(String name, String server) {
		return ffrep.getFreeFireByPPosition(name, server);
	}
	public List<FreeFire> getDataByNamePara(String name, String server) {
		return ffrep.getFreeFireByPName(name, server);
	}

	@Transactional
	public int deleteDataQuery(String name) {
		 return ffrep.deleteFreeFireByName(name);
	}
	@Transactional
	public int updateFreeFire(String name, String elite, String id) {
		return ffrep.updateFreeFire(name,elite,id);
	}
	public List<FreeFire> getDataFreeFire(String elite) {
		return ffrep.getDataFreeFire(elite);
	}

	public List<Tournament> getDataTournament() {
		return TRep.findAll();
	}

	public Tournament saveDataTournament(Tournament data) {
		return TRep.save(data);
	}
}
