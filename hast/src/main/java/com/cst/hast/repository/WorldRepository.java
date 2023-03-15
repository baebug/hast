package com.cst.hast.repository;

import com.cst.hast.entity.WorldEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorldRepository extends JpaRepository<WorldEntity, Long> {
}
