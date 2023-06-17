package com.example.ff.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ff.model.LoginForm;

public interface LoginRepository extends JpaRepository<LoginForm,String>{
}
