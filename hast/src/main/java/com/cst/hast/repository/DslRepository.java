package com.cst.hast.repository;


import com.cst.hast.dto.Article;
import com.cst.hast.dto.ChartData;
import com.cst.hast.entity.ExportEntity;
import com.cst.hast.entity.PointEntity;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.cst.hast.entity.QPointEntity.pointEntity;
import static com.cst.hast.entity.QExportEntity.exportEntity;
import static com.querydsl.core.types.Projections.constructor;

@Repository
@RequiredArgsConstructor
public class DslRepository {


    private final JPAQueryFactory queryFactory;

    // -+ 0.2 반경 내 기사 리스트 500개
    public List<PointEntity> findByLocation(double minLat, double maxLat, double minLong, double maxLong) {

        return queryFactory.selectDistinct(
                    constructor(PointEntity.class,
                            pointEntity.pointEventId, pointEntity.pointKorComment, pointEntity.pointEngComment, pointEntity.pointUrl, pointEntity.pointImage, pointEntity.pointCategory,
                            pointEntity.pointScore, pointEntity.pointDatetime)
                )
                .from(pointEntity)
                .where(pointEntity.pointEventId.in(
                        JPAExpressions.select(exportEntity.exportEventId)
                                .from(exportEntity)
                                .where(exportEntity.exportLat.between(minLat, maxLat)
                                        .and(exportEntity.exportLong.between(minLong, maxLong))
                                )
                ))
                .limit(500)
                .fetch();
    }

    // 2d 맵 점 찍기
    // dto로 받기
    public List<ExportEntity> findLatLongCountScore() {
        return queryFactory.select(constructor(
                        ExportEntity.class,
                        exportEntity.exportLat,
                        exportEntity.exportLong,
                        exportEntity.exportScore.sum(),
                        exportEntity.exportRowCount.sum()))
                .from(exportEntity)
                .groupBy(exportEntity.exportLat, exportEntity.exportLong)
                .fetch();
    }

    // 2d 맵 사이드바 기사 500개
    public List<PointEntity> findUpdatedArticles(String code) {
        return queryFactory.selectFrom(pointEntity)
                .where(pointEntity.pointScore.goe(0)
                        .and(pointEntity.pointCountryCode.eq(code)))
                .orderBy(pointEntity.pointDatetime.desc())
                .limit(500)
                .fetch();
    }

    // 메인 페이지 점
    // dto로 받기
    public List<ExportEntity> findCountryScore() {
        return queryFactory.select(constructor(
                        ExportEntity.class,
                        exportEntity.exportCountryCode,
                        exportEntity.exportScore.sum(),
                        exportEntity.exportRowCount.sum()))
                .from(exportEntity)
                .fetch();
    }

    // 메인페이지 국가 위험도순 순위
    public List<PointEntity> findCountryByScore() {
        return queryFactory.selectFrom(pointEntity)
                .groupBy(pointEntity.pointCountryCode)
                .orderBy(pointEntity.pointScore.desc())
                .limit(10)
                .fetch();
    }

}

