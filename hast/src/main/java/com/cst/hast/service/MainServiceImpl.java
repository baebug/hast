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
    private final EventRepository eventRepository;
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

    // gkg + event
    @Override
    public List<UpdateArticleDto> getUpdateArticles() {
        List<EventEntity> eventList = eventRepository.findAll();
        List<GkgEntity> gkgList = gkgRepository.findAll();

        List<UpdateArticleDto> respList = new ArrayList<>();

        for(EventEntity event : eventList) {
            UpdateArticleDto resp = UpdateArticleDto.builder()
                    .url(event.getEventUrl())
//                    .headline(event.)
                    .build();
            respList.add(resp);
        }

        for(GkgEntity gkg : gkgList) {
            UpdateArticleDto resp = UpdateArticleDto.builder()
                    .url(gkg.getGkgUrl())
//                    .headline(gkg.)
                    .build();
            respList.add(resp);
        }


        return respList;
    }

//    @Override
//    public List<CountryInfoDto> getKorCountryInfo() {
//        List<KorInfoEntity> countryList = korInfoRepository.findAll();
//
//        List<CountryInfoDto> respList = new ArrayList<>();
//        for(KorInfoEntity korInfo : countryList) {
//            CountryInfoDto resp = CountryInfoDto.builder()
//                    .wordId(korInfo.getWorldId())
//                    .name(korInfo.getInfoName())
//                    .capital(korInfo.getInfoCapital())
//                    .money(korInfo.getInfoMoney())
//                    .population(korInfo.getInfoPopul())
//                    .size(korInfo.getInfoSize())
//                    .build();
//
//            respList.add(resp);
//        }
//
//        return respList;
//    }
//
//    @Override
//    public List<CountryInfoDto> getEngCountryInfo() {
//        List<EngInfoEntity> countryList = engInfoRepository.findAll();
//
//        List<CountryInfoDto> respList = new ArrayList<>();
//        for(EngInfoEntity engInfo : countryList) {
//            CountryInfoDto resp = CountryInfoDto.builder()
//                    .wordId(engInfo.getWorldId())
//                    .name(engInfo.getInfoName())
//                    .capital(engInfo.getInfoCapital())
//                    .money(engInfo.getInfoMoney())
//                    .population(engInfo.getInfoPopul())
//                    .size(engInfo.getInfoSize())
//                    .build();
//
//            respList.add(resp);
//        }
//
//        return respList;
//    }

    @Override
    public List<SafetyEntity> getSafety(Long worldId) {
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

        return null;
    }

    @Override
    public List<ArticleDto> getCountryArticles(Long wordId) {
//        List<EventEntity> articleList = eventRepository.findAllById(wordId);
        List<ArticleDto> respList = new ArrayList<>();

        return respList;
    }

    @Override
    public List<ArticleDto> getCityArticles() {
//        List<EventEntity> articleList = eventRepository.findAllById(wordId);
        List<ArticleDto> respList = new ArrayList<>();

        return respList;

    }
}
