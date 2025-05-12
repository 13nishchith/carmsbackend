package com.carms.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carms.data.entity.CarsEntity;

@Repository
public interface CarsRepository extends JpaRepository<CarsEntity, Long>{

}
