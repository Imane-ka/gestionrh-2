package com.ormva_tf.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ormva_tf.entities.Filiere;



public interface FiliereRepository extends JpaRepository<com.ormva_tf.entities.Filiere, Integer> {
	@Query("select f from Filiere f where f.nom like :x")
	public Page<Filiere> chercherFiliere(@Param("x")String mc , Pageable pg);
}
