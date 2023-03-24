package com.cst.hast.service;

import com.cst.hast.dto.Article;
import com.cst.hast.dto.Statics;
import com.cst.hast.entity.ArticleEntity;
import com.cst.hast.exception.HastApplicationException;
import com.cst.hast.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
        LocalDateTime past = current.minusMinutes(15);

        return articleRepository.findAllByArticleDateBetween(Timestamp.valueOf(past), Timestamp.valueOf(current)).
                stream().map(Article::fromEntity).collect(Collectors.toList());
    }

    public List<Article> getCountryArticles(String code) {
        return articleRepository.findAllByArticleCountryCodeOrderByArticleDate(code).stream().map(Article::fromEntity).collect(Collectors.toList());
    }

    public List<Article> getCityArticles(double lat, double lon) {
        return articleRepository.findAllByArticleLatAndArticleLongOrderByArticleDate(lat, lon).stream().map(Article::fromEntity).collect(Collectors.toList());
    }

    public List<Statics> getStatics(String code) {
        ArticleEntity article = articleRepository.findByArticleCountryCode(code).orElseThrow(
                () -> { throw new HastApplicationException();
        });
        return statisticsRepository.findAllByStatisticsCountryCodeOrderByStatisticsMonthAsc(article.getArticleBaseCode()).stream().map(Statics::fromEntity).collect(Collectors.toList());
    }
}
