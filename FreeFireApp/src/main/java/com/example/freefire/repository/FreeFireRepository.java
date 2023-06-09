package com.example.freefire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.freefire.model.FreeFire;

@Repository
public interface FreeFireRepository extends JpaRepository<FreeFire,Integer>{
	//positionalParameter
	@Query("select f from FreeFire f where f.name=?1 and f.region=?2")
	List<FreeFire> getFreeFireByPPosition(String name,String server);
	
	//nameParameter
	@Query("select f from FreeFire f where f.name=:name and f.region=:server")
	List<FreeFire> getFreeFireByPName(String name,String server);

	@Modifying
	@Query("delete from FreeFire f where f.name=?1")
	public int deleteFreeFireByName(String name);
	
	@Modifying
	@Query("update FreeFire f set f.name=?1,f.elite=?2 where f.id=?3")
	public int updateFreeFire(String name,String elite,String id);
	
	@Query(value="select * from free_fire f where f.elite=?1", nativeQuery=true)
	public List<FreeFire> getDataFreeFire(String elite);
	
	List<FreeFire> findByRegion(String server);
	List<FreeFire> findByRegionStartingWith(String server);
	List<FreeFire> findByRegionEndingWith(String server);
}
