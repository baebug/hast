package com.cst.hast.service;

import com.cst.hast.dto.Article;
import com.cst.hast.dto.Measure;
import com.cst.hast.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class MainService {

    private final ArticleRepository articleRepository;
    private final StatisticsRepository statisticsRepository;


    public List<Article> getUpdateArticles() {
        return articleRepository.findAll().stream().map(Article::fromEntity).collect(Collectors.toList());
    }

    public List<Article> getCountryArticles(String code) {
        return articleRepository.findAllByExportCountry(code).stream().map(Article::fromEntity).collect(Collectors.toList());
    }

    public List<Article> getCityArticles(double lat, double lon) {
        return articleRepository.findAllByExportLatAndExportLong(lat, lon).stream().map(Article::fromEntity).collect(Collectors.toList());
    }

    public List<Measure> getMeasures(String code) {
        return statisticsRepository.findAllByStatisticsCountryCodeOrderByStatisticsMonthAsc(code).stream().map(Measure::fromEntity).collect(Collectors.toList());
    }
}
