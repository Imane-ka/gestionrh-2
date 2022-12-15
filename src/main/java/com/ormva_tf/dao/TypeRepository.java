package com.ormva_tf.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ormva_tf.entities.Type;



public interface TypeRepository extends JpaRepository<com.ormva_tf.entities.Type, Integer> {
	@Query("select t from Type t where t.nom like :x")
	public Page<Type> chercherType(@Param("x")String mc , Pageable pg);
}
