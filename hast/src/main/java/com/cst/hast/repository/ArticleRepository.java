package com.cst.hast.repository;

import com.cst.hast.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

//    @Query("SELECT a FROM ArticleEntity a WHERE a.articleDate between :past and :current")
    List<ArticleEntity> findAllByArticleDateTimeBetween(Timestamp past, Timestamp current);

    List<ArticleEntity> findAllByArticleCountryCodeOrderByArticleDateTime(String code);

    List<ArticleEntity> findAllByArticleLatAndArticleLongOrderByArticleDateTime(float lat, float lon);

    Optional<ArticleEntity> findByArticleCountryCode(String code);
}
