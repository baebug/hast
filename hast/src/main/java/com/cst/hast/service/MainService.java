package com.cst.hast.service;

import com.cst.hast.dto.*;
import com.cst.hast.dto.response.ChartDataResponse;
import com.cst.hast.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


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
//    public List<Article> getUpdateArticles() {
//        LocalDateTime current = LocalDateTime.now();
//        LocalDateTime past = current.minusMinutes(15);
//
//        return articleRepository.findTop10ByArticleDateTimeBetweenOrderByArticleScoreDesc(Timestamp.valueOf(past), Timestamp.valueOf(current)).
//                stream().map(Article::fromEntity).collect(Collectors.toList());
//    }

    public List<Article> getUpdateArticles() {

        return articleRepository.findTop10ByOrderByArticleDateTimeDescArticleScoreDesc().
                stream().map(Article::fromEntity).collect(Collectors.toList());
    }

    // 국가 기사 최신순 500개
    public List<Article> getCountryArticles(String code) {
        return articleRepository.findTop500ByArticleCountryCodeOrderByArticleDateTimeDesc(code).stream().map(Article::fromEntity).collect(Collectors.toList());
    }

    // 받은 위도, 겯도 반경 0.3 기사
    public List<Article> getLatLongArticles(float lat, float lon) {
        float interval = 0.2F;
        return articleRepository.findByLocation(lat - interval, lat + interval, lon - interval, lon + interval, PageRequest.of(0, 500)).stream().map(Article::fromEntity).collect(Collectors.toList());
    }

    // 치안 수치 (시각화)
    public ChartData getChartData(String code) {
        List<WorldChartData> worldChartData = statisticsRepository.findAllByStatisticsCountryCodeOrderByStatisticsMonthAsc("ZZ").stream().map(WorldChartData::fromEntity).collect(Collectors.toList());
        List<CountryChartData> countryChartData = statisticsRepository.findAllByStatisticsCountryCodeOrderByStatisticsMonthAsc(code).stream().map(CountryChartData::fromEntity).collect(Collectors.toList());
        return new ChartData(countryChartData, worldChartData);
    }

    // 위도, 경도, 같은 개수, 치안 수치
    public Collection<Dots> getLatLongCountScore() {
        return articleRepository.findLatLongCountScore().stream().map(Dots::fromEntity).collect(Collectors.toList());
    }

    public Collection<CountryScore> getCountryScore() {
        return articleRepository.findCountryScore().stream().map(CountryScore::fromEntity).collect(Collectors.toList());
    }

}
