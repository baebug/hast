package com.cst.hast.controller;


import com.cst.hast.common.Response;
import com.cst.hast.dto.response.*;
import com.cst.hast.exception.HastApplicationException;
import com.cst.hast.service.MainService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @ApiOperation(value="최신 기사 목록 조회", notes="정상 동작 시 'result' return")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 작동"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping(value = "/articles/updates")
    public Response<List<UpdateArticleResponse>> getUpdateArticles() {
        log.info("get updated articles");
        return Response.of(mainService.getUpdateArticles().stream().map(UpdateArticleResponse::fromArticle).collect(Collectors.toList()));
    }

    @ApiOperation(value="국가 기사 목록 조회", notes="정상 동작 시 'result' return")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 작동"),
            @ApiResponse(code = 500, message = "서버 에러")
    })

    @GetMapping("/articles/{code}")
    public Response<List<CountryArticleResponse>> getCountryArticles(@PathVariable String code) {
        log.info("get country articles");
        return Response.of(mainService.getCountryArticles(code).stream().map(CountryArticleResponse::fromArticle).collect(Collectors.toList()));
    }

    @ApiOperation(value="월별 수치 목록 조회", notes="정상 동작 시 'result' return")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 작동"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("/measures/{code}")
    public Response<List<StaticsResponse>> getScore(@PathVariable String code) {
        log.info("get measures");
        return Response.of(mainService.getStatics(code).stream().map(StaticsResponse::fromMeasure).collect(Collectors.toList()));
    }


    @ApiOperation(value="지역 기사 목록 조회", notes="정상 동작 시 'result' return")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 작동"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("/articles/{lat}/{lon}")
    public Response<List<CityArticleResponse>> getCityArticles(@PathVariable String lat, @PathVariable String lon) {
        log.info("get city articles");

        try {
            Float floatLat = Float.parseFloat(lat);
            Float floatLon = Float.parseFloat(lon);

            return Response.of(mainService.getCityArticles(floatLat, floatLon).stream().map(CityArticleResponse::fromArticle).collect(Collectors.toList()));
        } catch (NumberFormatException e) { // 잘못된 형식의 데이터
            throw new HastApplicationException();
        }
    }
}

// 1. 치안 점수 조회 (시각화)
// 2. 동그라미 그리는 점수 조회