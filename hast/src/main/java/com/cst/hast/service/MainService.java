package com.cst.hast.service;

import com.cst.hast.dto.respDto.ArticleDto;
import com.cst.hast.dto.respDto.CountryInfoDto;
import com.cst.hast.dto.respDto.UpdateArticleDto;
import com.cst.hast.dto.respDto.WorldInfoDto;
import com.cst.hast.entity.SafetyEntity;

import java.util.List;

public interface MainService {

    List<WorldInfoDto> getWorld();

    List<UpdateArticleDto> getUpdateArticles();

//    List<CountryInfoDto> getKorCountryInfo();
//
//    List<CountryInfoDto> getEngCountryInfo();

    List<SafetyEntity> getSafety(Long wordId);

    List<ArticleDto> getCountryArticles(Long wordId);

    List<ArticleDto> getCityArticles();

}
