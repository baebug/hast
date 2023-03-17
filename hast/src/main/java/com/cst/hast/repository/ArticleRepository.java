package com.cst.hast.repository;

import com.cst.hast.entity.ArticleEntity;
import com.cst.hast.entity.KorInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

    // 흠?
    @Query("SELECT a FROM ArticleEntity a WHERE a.worldEntity.worldId = :wordId")
    List<ArticleEntity> findAllByWorldId(Long wordId);

    List<ArticleEntity> findAllByLatitudeAndLongtitude(float lat, float lon);
}
