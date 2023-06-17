package com.example.ff.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ff.model.RegistrationForm;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationForm,Integer> {
	@Query(value = "select * from registration_form where region=:region and level>=:level", nativeQuery = true)
	List<RegistrationForm> findByRegionAndLevel(String region,int level);
	@Query("select r.id from RegistrationForm r where r.main_email=?1")
	int findId(String email);
	@Modifying
	@Query("delete from RegistrationForm r where r.name=?1")
	public int deleteFreeFireByName(String name);
	
	@Modifying
	@Query("update RegistrationForm r set r.name=?1,r.elite=?2 where r.id=?3")
	public int updateFreeFire(String name,String elite,String id);
	List<RegistrationForm> findByName(String name);
	List<RegistrationForm> findByNameStartingWith(String name);
	List<RegistrationForm> findByNameEndingWith(String name);
}