package com.cst.hast.service;

import com.cst.hast.dto.*;
import com.cst.hast.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class MainService {
    private final StatisticsRepository statisticsRepository;

    private final DslRepository dslRepository;


    // 최신 기사
//    public List<Article> getUpdateArticles() {
//        LocalDateTime current = LocalDateTime.now();
//        LocalDateTime past = current.minusMinutes(15);
//
//        return articleRepository.findTop10ByArticleDateTimeBetweenOrderByArticleScoreDesc(Timestamp.valueOf(past), Timestamp.valueOf(current)).
//                stream().map(Article::fromEntity).collect(Collectors.toList());
//    }

    public List<Country> getCountryByScore() {

        return dslRepository.findCountryByScore();
    }

    // 국가 기사 최신순 500개
    public List<Article> getCountryArticles(String code) {
        return dslRepository.findUpdatedArticles(code).stream().map(Article::fromEntity).collect(Collectors.toList());
    }

    // 받은 위도, 겯도 반경 0.3 기사
    public List<Article> getLatLongArticles(double lat, double lon) {
        float interval = 0.2F;
        return dslRepository.findByLocation(lat - interval, lat + interval, lon - interval, lon + interval).stream().map(Article::fromEntity).collect(Collectors.toList());
    }

    // 치안 수치 (시각화)
    public List<ChartData> getChartData(String code) {
        return statisticsRepository.findByCode(code);
    }

    // 위도, 경도, 같은 개수, 치안 수치
    public Collection<Dots> getLatLongCountScore() {
        return dslRepository.findLatLongCountScore().stream().map(Dots::fromEntity).collect(Collectors.toList());
    }

    public Collection<CountryScore> getCountryScore() {
        return dslRepository.findCountryScore().stream().map(CountryScore::fromEntity).collect(Collectors.toList());
    }

}
