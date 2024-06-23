package com.emp.backend.repo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.emp.backend.entity.EmployeeEntity;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long>{

	@Query(value="SELECT * FROM employee WHERE frist_Name=:frist_Name AND last_Name=:last_Name",nativeQuery = true)
	EmployeeEntity findByFristnameAndLastname(@Param("frist_Name") String frist_Name, @Param("last_Name") String last_Name);

	
	@Query(value = " SELECT * FROM employee ud WHERE ud.email = :email ", nativeQuery = true)
	EmployeeEntity findByEmailId(@Param(value = "email") String email);
	
	Optional<EmployeeEntity> findByEmailAndPassword(String email,String password);
	
	@Transactional
	@Query(value = " DELETE * FROM employee ud WHERE ud.email = :email ", nativeQuery = true)
	EmployeeEntity deleteByEmailId(@Param(value = "email") String email);
}
