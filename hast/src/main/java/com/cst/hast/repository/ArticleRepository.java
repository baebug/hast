package com.cst.hast.repository;

import com.cst.hast.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

    List<ArticleEntity> findAllByWorldId(Long wordId);

    List<ArticleEntity> findAllByLatitudeAndLongitude(float lat, float lon);
}
