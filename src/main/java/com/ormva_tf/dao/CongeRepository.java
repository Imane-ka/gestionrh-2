package com.ormva_tf.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ormva_tf.entities.Conge;



public interface CongeRepository extends JpaRepository<com.ormva_tf.entities.Conge, Long> {
	@Query("select c from Conge c where c.employe.cin like :x")
	public Page<Conge> chercherConge(@Param("x")String mc , Pageable pg);
	@Transactional
	@Modifying
	@Query("update Conge c set c.status = 'accepter' where c.id = :x")
	public void StatusAccepter(@Param("x")Long id);
	@Transactional
	@Modifying
	@Query("update Conge c set c.status = 'refuser' where c.id = :x")
	public void StatusRefuser(@Param("x")Long id);
}
