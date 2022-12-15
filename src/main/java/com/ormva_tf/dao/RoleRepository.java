package com.ormva_tf.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ormva_tf.sec.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
}
