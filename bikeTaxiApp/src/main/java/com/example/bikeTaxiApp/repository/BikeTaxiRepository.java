package com.example.bikeTaxiApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bikeTaxiApp.model.BikeTaxi;

@Repository
public interface BikeTaxiRepository extends JpaRepository<BikeTaxi,String>{
	
}
