package com.cst.hast.repository;

import com.cst.hast.entity.ArticleEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
    // 최신 기사
    List<ArticleEntity> findTop10ByOrderByArticleDateTimeDescArticleScoreDesc();
//    List<ArticleEntity> findTop10ByArticleDateTimeBetweenOrderByArticleScoreDesc(Timestamp past, Timestamp current);

    // 위도, 경도, 같은 개수, 치안 수치
    @Query("SELECT new ArticleEntity(a.articleLat, a.articleLong, COUNT(*), SUM(a.articleScore), SUM(a.articleRowCount))" +
            "FROM ArticleEntity a " +
            "GROUP BY a.articleLat, a.articleLong")
    List<ArticleEntity> findLatLongCountScore();

    // 최신순 기사 500개
    List<ArticleEntity> findTop500ByArticleCountryCodeOrderByArticleDateTime(String code);

    // 받은 위도 경도 between -0.3, +0.3 기사 500개
    @Query("SELECT a " +
            "FROM ArticleEntity a " +
            "WHERE a.articleLat BETWEEN :minLat AND :maxLat " +
            "AND a.articleLong BETWEEN :minLong AND :maxLong " +
            "ORDER BY SQRT(POWER(:centerLat - a.articleLat, 2) + POWER(:centerLong - a.articleLong, 2)), a.articleScore DESC")
    List<ArticleEntity> findByLocation(@Param("minLat") float minLat, @Param("maxLat") float maxLat, @Param("minLong") float minLong, @Param("maxLong") float maxLong,
                                       @Param("centerLat") float centerLat, @Param("centerLong") float centerLong, Pageable pageable);

    // 치안 수치 얻을 때 article table 찾기 위함
    Optional<ArticleEntity> findByArticleCountryCode(String code);
}
