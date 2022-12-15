package com.ormva_tf.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ormva_tf.entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe, String> {
//	@Query("select e from Employe e where e.cin like :x")
//	public Employe getByCin(@Param("x") String cin);

	@Query("select e from Employe e where e.cin like :x")
	public Page<Employe> chercherEmploye(@Param("x")String mc , Pageable pg);
}
