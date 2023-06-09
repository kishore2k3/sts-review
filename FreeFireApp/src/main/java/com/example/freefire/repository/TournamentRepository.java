package com.example.freefire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.freefire.model.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament,Integer>{

}
