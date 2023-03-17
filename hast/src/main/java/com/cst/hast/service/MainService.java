package com.cst.hast.service;

import com.cst.hast.dto.respDto.*;
import com.cst.hast.entity.SafetyEntity;

import java.util.List;

public interface MainService {

    List<WorldInfoDto> getWorld();

    List<UpdateArticleDto> getUpdateArticles();

    List<CountryInfoDto> getKorCountryInfo();

    List<CountryInfoDto> getEngCountryInfo();

    SafetyDto getSafety(Long wordId);

    List<ArticleDto> getCountryArticles(Long wordId);

    List<ArticleDto> getCityArticles(float lat, float lon);
}
