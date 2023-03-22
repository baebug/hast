package com.cst.hast.service;

import com.cst.hast.dto.Article;
import com.cst.hast.dto.Measure;
import com.cst.hast.entity.ArticleEntity;
import com.cst.hast.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class MainService {

    private final ArticleRepository articleRepository;
    private final StatisticsRepository statisticsRepository;


    public List<Article> getUpdateArticles() {
        LocalDateTime current = LocalDateTime.now();
        LocalDateTime past = current.minusDays(2);

        List<ArticleEntity> list = articleRepository.findAllByArticleDateBetween(Timestamp.valueOf("2023-03-22 16:49:41.2860528"), Timestamp.valueOf("2023-03-22 17:04:41.286052"));

        log.info(list.toString());
        for(ArticleEntity a : list) {
            log.info("list : " + a.toString());
        }

        return articleRepository.findAllByArticleDateBetween(Timestamp.valueOf(past), Timestamp.valueOf(current)).
                stream().map(Article::fromEntity).collect(Collectors.toList());
    }

    public List<Article> getCountryArticles(String code) {
        return articleRepository.findAllByArticleCountryCodeOrderByArticleDate(code).stream().map(Article::fromEntity).collect(Collectors.toList());
    }

    public List<Article> getCityArticles(double lat, double lon) {
        return articleRepository.findAllByArticleLatAndArticleLongOrderByArticleDate(lat, lon).stream().map(Article::fromEntity).collect(Collectors.toList());
    }

    public List<Measure> getScore(String code) {
        return statisticsRepository.findAllByStatisticsCountryCodeOrderByStatisticsMonthAsc(code).stream().map(Measure::fromEntity).collect(Collectors.toList());
    }
}
