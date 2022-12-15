package com.ormva_tf.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ormva_tf.sec.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {
}
