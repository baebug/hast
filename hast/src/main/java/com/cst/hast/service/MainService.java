package com.cst.hast.service;

import com.cst.hast.dto.Article;
import com.cst.hast.dto.Safety;
import com.cst.hast.entity.*;
import com.cst.hast.exception.ErrorCode;
import com.cst.hast.exception.HastApplicationException;
import com.cst.hast.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class MainService {

    private final MentionRepository mentionRepository;
    private final ArticleRepository articleRepository;
    private final GkgRepository gkgRepository;
    private final SafetyRepository safetyRepository;


    public List<Article> getUpdateArticles() {
        return articleRepository.findAll().stream().map(Article::fromEntity).collect(Collectors.toList());
    }

    public List<Article> getCountryArticles(Long wordId) {
        return articleRepository.findAllByWorldId(wordId).stream().map(Article::fromEntity).collect(Collectors.toList());
    }

    public List<Article> getCityArticles(float lat, float lon) {
        return articleRepository.findAllByLatitudeAndLongitude(lat, lon).stream().map(Article::fromEntity).collect(Collectors.toList());
    }

    public Safety getSafety(Long worldId) {
        return safetyRepository.findById(worldId).map(Safety::fromEntity).orElseThrow((() -> {
            throw new HastApplicationException(ErrorCode.SAFETY_NOT_FOUND, String.format("safety of %d is not founded", worldId)); // SafteyNotFoundException
        }));
    }
}
