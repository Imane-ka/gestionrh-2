package com.ormva_tf.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ormva_tf.entities.EmplFonction;
import com.ormva_tf.entities.KeyEmplFonct;



public interface EmplFonctionRepository extends JpaRepository<EmplFonction, KeyEmplFonct> {
	@Query("select e from EmplFonction e where e.id.fonction.nom like :x")
	public Page<EmplFonction> chercherEmplFonct(@Param("x")String mc , Pageable pg);

}
