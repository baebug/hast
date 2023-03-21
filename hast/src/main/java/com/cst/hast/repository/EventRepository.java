package com.cst.hast.repository;

import com.cst.hast.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepository extends JpaRepository<EventEntity, Long> {
}
