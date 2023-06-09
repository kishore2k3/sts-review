package com.example.bikeTaxiApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bikeTaxiApp.model.BikeTaxiLogin;

@Repository
public interface BikeTaxiLoginRepository extends JpaRepository<BikeTaxiLogin,String>{
}
