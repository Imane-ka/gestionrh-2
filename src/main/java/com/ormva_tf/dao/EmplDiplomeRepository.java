package com.ormva_tf.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ormva_tf.entities.EmplDiplome;
import com.ormva_tf.entities.KeyEmplDiplm;



public interface EmplDiplomeRepository extends JpaRepository<EmplDiplome, KeyEmplDiplm> {
	@Query("select e from EmplDiplome e where e.id.diplome.nom like :x")
	public Page<EmplDiplome> chercherEmplDiplm(@Param("x")String mc , Pageable pg);

}
