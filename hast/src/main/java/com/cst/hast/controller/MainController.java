package com.cst.hast.controller;


import com.cst.hast.common.Response;
import com.cst.hast.common.ResultEnum;
import com.cst.hast.dto.Safety;
import com.cst.hast.dto.response.*;
import com.cst.hast.service.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final MainService mainService;

    /**
     *
     * @produces (반환 타입)
     */
    @GetMapping(value = "/updates/articles")
    public Response<List<UpdateArticleResponse>> getUpdateArticles() {
        log.info("get updated articles");
        return Response.of(mainService.getUpdateArticles().stream().map(UpdateArticleResponse::fromArticle).collect(Collectors.toList()), ResultEnum.SUCCESS);
    }

    @GetMapping("/safety/{worldId}")
    public Response<?> getSafety(@PathVariable Long worldId) {
        log.info("get safety");
        Safety safety = mainService.getSafety(worldId);
        if(safety == null)
            return Response.ofSuccess();

        return Response.of(SafetyResponse.fromSafety(
                safety
        ), ResultEnum.SUCCESS);
    }

    @GetMapping("/articles/{worldId}")
    public Response<List<CountryArticleResponse>> getCountryArticles(@PathVariable Long worldId) {
        log.info("get country articles");
        return Response.of(mainService.getCountryArticles(worldId).stream().map(CountryArticleResponse::fromArticle).collect(Collectors.toList()), ResultEnum.SUCCESS);
    }

    @GetMapping("/articles/{lat}/{lon}")
    public Response<List<CityArticleResponse>> getCityArticles(@PathVariable float lat, @PathVariable float lon) {
        log.info("get city articles");
        return Response.of(mainService.getCityArticles(lat, lon).stream().map(CityArticleResponse::fromArticle).collect(Collectors.toList()), ResultEnum.SUCCESS);
    }

}

// 1. 치안 점수 조회 (시각화)
// 2. 동그라미 그리는 점수 조회