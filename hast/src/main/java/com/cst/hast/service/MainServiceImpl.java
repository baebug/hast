package com.cst.hast.service;

import com.cst.hast.dto.respDto.*;
import com.cst.hast.entity.*;
import com.cst.hast.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {

    private final EngInfoRepository engInfoRepository;
    private final MentionRepository mentionRepository;
    private final ArticleRepository articleRepository;
    private final GkgRepository gkgRepository;
    private final KorInfoRepository korInfoRepository;
    private final SafetyRepository safetyRepository;
    private final WorldRepository worldRepository;

    @Override
    public List<WorldInfoDto> getWorld() {
        List<WorldEntity> worldList = worldRepository.findAll();

        List<WorldInfoDto> respList = new ArrayList<>();
        for(WorldEntity world : worldList) {
            WorldInfoDto resp = WorldInfoDto.builder()
                    .wordId(world.getWorldId())
                    .worldLatitude(world.getWorldLatitude())
                    .worldLongtitude(world.getWorldLongtitude())
                    .worldEngName(world.getWorldEngName())
                    .build();

            respList.add(resp);
        }

        return respList;
    }

    @Override
    public List<UpdateArticleDto> getUpdateArticles() {
        List<ArticleEntity> articleList = articleRepository.findAll();

        List<UpdateArticleDto> respList = new ArrayList<>();

        for(ArticleEntity article : articleList) {
            UpdateArticleDto resp = UpdateArticleDto.builder()
                    .url(article.getUrl())
                    .headline(article.getHeadline())
                    .build();
            respList.add(resp);
        }

        return respList;
    }

    @Override
    public List<CountryInfoDto> getKorCountryInfo() {
        List<KorInfoEntity> countryList = korInfoRepository.findAll();

        List<CountryInfoDto> respList = new ArrayList<>();
        for(KorInfoEntity korInfo : countryList) {
            CountryInfoDto resp = CountryInfoDto.builder()
                    .wordId(korInfo.getWorldId())
                    .name(korInfo.getInfoName())
                    .capital(korInfo.getInfoCapital())
                    .money(korInfo.getInfoMoney())
                    .population(korInfo.getInfoPopul())
                    .size(korInfo.getInfoSize())
                    .build();

            respList.add(resp);
        }

        return respList;
    }

    @Override
    public List<CountryInfoDto> getEngCountryInfo() {
        List<EngInfoEntity> countryList = engInfoRepository.findAll();

        List<CountryInfoDto> respList = new ArrayList<>();
        for(EngInfoEntity engInfo : countryList) {
            CountryInfoDto resp = CountryInfoDto.builder()
                    .wordId(engInfo.getWorldId())
                    .name(engInfo.getInfoName())
                    .capital(engInfo.getInfoCapital())
                    .money(engInfo.getInfoMoney())
                    .population(engInfo.getInfoPopul())
                    .size(engInfo.getInfoSize())
                    .build();

            respList.add(resp);
        }

        return respList;
    }

    // 훔
    @Override
    public SafetyDto getSafety(Long worldId) {
        SafetyEntity safety = safetyRepository.findById(worldId).orElseThrow((() -> {
            throw new NullPointerException(); // SafteyNotFoundException
        }));

        Long[] safetyArr = new Long[12];
        safetyArr[0] = safety.getSafety1();
        safetyArr[1] = safety.getSafety2();
        safetyArr[2] = safety.getSafety3();
        safetyArr[3] = safety.getSafety4();
        safetyArr[4] = safety.getSafety5();
        safetyArr[5] = safety.getSafety6();
        safetyArr[6] = safety.getSafety7();
        safetyArr[7] = safety.getSafety8();
        safetyArr[8] = safety.getSafety9();
        safetyArr[9] = safety.getSafety10();
        safetyArr[10] = safety.getSafety11();
        safetyArr[11] = safety.getSafety12();

        SafetyDto resp = SafetyDto.builder()
                .safety(safetyArr)
                .build();

        return resp;
    }

    @Override
    public List<ArticleDto> getCountryArticles(Long wordId) {
        List<ArticleEntity> countryArticleList = articleRepository.findAllByWorldId(wordId);

        return getArticleDtoList(countryArticleList);
    }



    @Override
    public List<ArticleDto> getCityArticles(float lat, float lon) {
        List<ArticleEntity> cityAtricleList = articleRepository.findAllByLatitudeAndLongtitude(lat, lon);

        return getArticleDtoList(cityAtricleList);
    }

    private List<ArticleDto> getArticleDtoList(List<ArticleEntity> articleList) {
        List<ArticleDto> respList = new ArrayList<>();

        for(ArticleEntity article : articleList) {
            ArticleDto resp = ArticleDto.builder()
                    .img(article.getImg())
                    .url(article.getUrl())
                    .headline(article.getHeadline())
                    .category(article.getTheme())
                    .build();
            respList.add(resp);
        }

        return respList;
    }
}
