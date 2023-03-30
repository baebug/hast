package com.cst.hast.repository;
import com.cst.hast.entity.StatisticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StatisticsRepository extends JpaRepository<StatisticsEntity, Long> {

    List<StatisticsEntity> findAllByStatisticsCountryCodeOrderByStatisticsMonthAsc(String code);

}
