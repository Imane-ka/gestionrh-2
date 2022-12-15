package com.ormva_tf.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ormva_tf.entities.Diplome;
import com.ormva_tf.entities.Employe;
import com.ormva_tf.entities.Entite;

public interface DiplomeRepository extends JpaRepository<Diplome, Integer> {
	@Query("select d from Diplome d where d.nom like :x")
	public Page<Diplome> chercherDiplome(@Param("x")String mc , Pageable pg);
}
