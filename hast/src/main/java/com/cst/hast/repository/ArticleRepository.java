package com.cst.hast.repository;

import com.cst.hast.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

//    @Query("SELECT a FROM ArticleEntity a WHERE a.articleDate between :past and :current")
    List<ArticleEntity> findAllByArticleDateBetween(Timestamp past, Timestamp current);

    List<ArticleEntity> findAllByArticleCountryCodeOrderByArticleDate(String code);

    List<ArticleEntity> findAllByArticleLatAndArticleLongOrderByArticleDate(double lat, double lon);

}
