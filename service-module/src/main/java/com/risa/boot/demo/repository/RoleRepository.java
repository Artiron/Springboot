package com.risa.boot.demo.repository;


import com.risa.boot.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
