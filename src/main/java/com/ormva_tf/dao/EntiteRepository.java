package com.ormva_tf.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ormva_tf.entities.Employe;
import com.ormva_tf.entities.Entite;

public interface EntiteRepository extends JpaRepository<Entite, Long> {
	@Query("select e from Entite e where e.nom like :x")
	public Page<Entite> chercherEntite(@Param("x")String mc , Pageable pg);
}
