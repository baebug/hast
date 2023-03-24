package com.cst.hast.repository;

import com.cst.hast.entity.CameoEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepository extends JpaRepository<CameoEntity, Long> {
}
