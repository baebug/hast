package com.cst.hast.repository;

import com.cst.hast.entity.StaticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StatisticsRepository extends JpaRepository<StaticsEntity, Long> {

    List<StaticsEntity> findAllByStatisticsCountryCodeOrderByStatisticsMonthAsc(String code);

}
