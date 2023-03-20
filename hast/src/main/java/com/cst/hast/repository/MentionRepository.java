package com.cst.hast.repository;

import com.cst.hast.entity.MentionEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MentionRepository extends JpaRepository<MentionEntity, Long> {
}
