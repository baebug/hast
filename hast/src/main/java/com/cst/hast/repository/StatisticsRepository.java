package com.cst.hast.repository;
import com.cst.hast.dto.ChartData;
import com.cst.hast.entity.StatisticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface StatisticsRepository extends JpaRepository<StatisticsEntity, Long> {

    @Query("SELECT new com.cst.hast.dto.ChartData(s1.statisticsMonth, s1.statisticsGkgTone, s2.statisticsGkgTone, "
            + "s1.statisticsRowCount, s1.statisticsCrimeCount, " +
            "s1.statisticsAccidentCount, "
            + "s1.statisticsDiseaseCount, "
            + "s1.statisticsDisasterCount, "
            + "s1.statisticsPoliticCount, "
            + "s1.statisticsEtcCount)" +
            "FROM StatisticsEntity s1 JOIN StatisticsEntity s2 " +
            "ON s1.statisticsMonth = s2.statisticsMonth " +
            "WHERE s1.statisticsCountryCode =:countryCode AND s2.statisticsCountryCode = 'ZZ' " +
            "ORDER BY CAST(s1.statisticsMonth AS integer)")

    List<ChartData> findByCode(@Param("countryCode") String countryCode);


//    @Query("SELECT " +
//            "NEW com.cst.hast.dto.ChartData( " +
//            "s1.statisticsMonth, " +
//            "s1.statisticsGkgTone, " +
//            "s2.statisticsGkgTone, " +
//            "s1.statisticsRowCount, " +
//            "s1.statisticsCrimeCount, " +
//            "s1.statisticsAccidentCount, " +
//            "s1.statisticsDiseaseCount, " +
//            "s1.statisticsDisasterCount, " +
//            "s1.statisticsPoliticCount, " +
//            "s1.statisticsEtcCount " +
//            ") " +
//            "FROM ( " +
//            "SELECT " +
//            "statisticsMonth, " +
//            "statisticsGkgTone / statisticsRowCount AS statisticsGkgTone, " +
//            "statisticsRowCount, " +
//            "statisticsCrimeCount, " +
//            "statisticsAccidentCount, " +
//            "statisticsDiseaseCount, " +
//            "statisticsDisasterCount, " +
//            "statisticsPoliticCount, " +
//            "statisticsEtcCount " +
//            "FROM StatisticsEntity " +
//            "WHERE statisticsCountryCode = :countryCode) " +
//            "AS s1 " +
//            "JOIN (" +
//            "SELECT " +
//            "statisticsMonth, " +
//            "statisticsGkgTone / statisticsRowCount AS statisticsGkgTone " +
//            "FROM StatisticsEntity " +
//            "WHERE statisticsCountryCode = 'ZZ') " +
//            "AS s2 " +
//            "ON s1.statisticsMonth = s2.statisticsMonth " +
//            "ORDER BY MONTH(CURRENT_DATE()) DESC")
//    List<ChartData> findByCode(@Param("countryCode") String countryCode);
}
