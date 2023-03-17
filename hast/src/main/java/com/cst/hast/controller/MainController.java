package com.cst.hast.controller;


import com.cst.hast.common.ResultDto;
import com.cst.hast.common.ResultEnum;
import com.cst.hast.dto.respDto.*;
import com.cst.hast.service.MainServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final MainServiceImpl mainService;

    @GetMapping("/world")
    public ResponseEntity<?> getWorld() {
        log.info("국가 정보 조회");
        List<WorldInfoDto> list = mainService.getWorld();
        return ResponseEntity.status(200).body(ResultDto.of(list, ResultEnum.SUCCESS));
    }

    /**
     *
     * @produces (반환 타입)
     */
    @GetMapping(value = "updates/articles")
    public ResponseEntity<?> getUpdateArticles() {
        log.info("최신 기사 조회");
        List<UpdateArticleDto> list = mainService.getUpdateArticles();
        return ResponseEntity.status(200).body(ResultDto.of(list, ResultEnum.SUCCESS));
    }

    @GetMapping("/eng")
    public ResponseEntity<?> getCountyEngInfo() {
        log.info("(ENG) 국가 기본 정보 조회");
        List<CountryInfoDto> list = mainService.getEngCountryInfo();
        return ResponseEntity.status(200).body(ResultDto.of(list, ResultEnum.SUCCESS));
    }

    @GetMapping("/kor")
    public ResponseEntity<?> getCountyKorInfo() {
        log.info("(KOR) 국가 기본 정보 조회");
        List<CountryInfoDto> list = mainService.getKorCountryInfo();
        return ResponseEntity.status(200).body(ResultDto.of(list, ResultEnum.SUCCESS));
    }

    @GetMapping("/safety/{worldId}")
    public ResponseEntity<?> getSafety(@PathVariable Long worldId) {
        log.info("치안 점수 조회");
        SafetyDto safety = mainService.getSafety(worldId);
        return ResponseEntity.status(200).body(ResultDto.of(safety, ResultEnum.SUCCESS));
    }

    @GetMapping("/articles/{worldId}")
    public ResponseEntity<?> getCountryArticles(@PathVariable Long worldId) {
        log.info("국가 기사 조회 (각 기사의 ton 정보 포함)");
        List<ArticleDto> list = mainService.getCountryArticles(worldId);
        return ResponseEntity.status(200).body(ResultDto.of(list, ResultEnum.SUCCESS));
    }

    @GetMapping("/articles/{lat}/{lon}")
    public ResponseEntity<?> getCityArticles(@PathVariable float lat, @PathVariable float lon) {
        log.info("지역 뉴스 조회");
        List<ArticleDto> list = mainService.getCityArticles(lat, lon);
        return ResponseEntity.status(200).body(ResultDto.of(list, ResultEnum.SUCCESS));
    }

}
