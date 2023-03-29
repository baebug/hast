package com.cst.hast.service;

import com.cst.hast.dto.Article;
import com.cst.hast.dto.Dots;
import com.cst.hast.dto.Statics;
import com.cst.hast.entity.ArticleEntity;
import com.cst.hast.exception.HastApplicationException;
import com.cst.hast.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class MainService {

    private final ArticleRepository articleRepository;
    private final StatisticsRepository statisticsRepository;


    // 최신 기사
    public List<Article> getUpdateArticles() {
        LocalDateTime current = LocalDateTime.now();
        LocalDateTime past = current.minusMinutes(15);

        return articleRepository.findTop10ByArticleDateTimeBetweenOrderByArticleScore(Timestamp.valueOf(past), Timestamp.valueOf(current)).
                stream().map(Article::fromEntity).collect(Collectors.toList());
    }

    // 국가 기사 최신순 500개
    public List<Article> getCountryArticles(String code) {
        return articleRepository.findTop500ByArticleCountryCodeOrderByArticleDateTime(code).stream().map(Article::fromEntity).collect(Collectors.toList());
    }

    // 받은 위도, 겯도 반경 0.3 기사
    public List<Article> getLatLongArticles(float lat, float lon) {
        return articleRepository.findByLocation(lat - 0.3F, lat + 0.3F, lon - 0.3F, lon + 0.3F, PageRequest.of(0, 500)).stream().map(Article::fromEntity).collect(Collectors.toList());
    }

    // 치안 수치 (시각화)
    public List<Statics> getStatics(String code) {
        return statisticsRepository.findAllByStatisticsCountryCodeOrderByStatisticsMonthAsc(code).stream().map(Statics::fromEntity).collect(Collectors.toList());
    }

    // 위도, 경도, 같은 개수, 치안 수치
    public Collection<Dots> getLatLongCountScore() {
        return articleRepository.findLatLongCountScore().stream().map(Dots::fromEntity).collect(Collectors.toList());
    }
}
