package com.example.ff.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ff.model.Tournament;


public interface TournamentRepository extends JpaRepository<Tournament,Integer>{

}
