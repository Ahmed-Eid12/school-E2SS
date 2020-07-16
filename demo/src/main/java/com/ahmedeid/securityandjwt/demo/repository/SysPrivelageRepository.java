package com.ahmedeid.securityandjwt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahmedeid.securityandjwt.demo.entities.SysPrivelage;

@Repository
public interface SysPrivelageRepository extends JpaRepository<SysPrivelage, Integer>{

}
