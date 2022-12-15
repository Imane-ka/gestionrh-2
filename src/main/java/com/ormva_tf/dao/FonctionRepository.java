package com.ormva_tf.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ormva_tf.entities.Employe;
import com.ormva_tf.entities.Fonction;

public interface FonctionRepository extends JpaRepository<Fonction, Integer> {
	@Query("select f from Fonction f where f.nom like :x")
	public Page<Fonction> chercherFonction(@Param("x")String mc , Pageable pg);
}
