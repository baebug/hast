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

    // 최신 기사
    @ApiOperation(value="최신 기사 목록 조회 (10개)", notes="정상 동작 시 'result' return")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 작동"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping(value = "/articles/updates")
    public Response<List<UpdateArticleResponse>> getUpdateArticles() {
        log.info("get updated articles");
        return Response.of(mainService.getUpdateArticles().stream().map(UpdateArticleResponse::fromArticle).collect(Collectors.toList()));
    }

    // 위도, 경도, 같은 개수, 치안 수치
    @ApiOperation(value="전세계 위도, 경도, 같은 위도 경도의 개수, 치안 수치 조회", notes="정상 동작 시 'result' return")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 작동"),
            @ApiResponse(code = 500, message = "서버 에러")
    })

    @GetMapping("/info/dots")
    public Response<List<DotsResponse>> getLatLongCountScore() {
        log.info("get dots info");
        return Response.of(mainService.getLatLongCountScore().stream().map(DotsResponse::fromDots).collect(Collectors.toList()));
    }

    // 최신순 기사 500개
    @ApiOperation(value="국가 최신순 기사 500개 조회", notes="정상 동작 시 'result' return")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 작동"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("/articles/{code}")
    public Response<List<CountryArticleResponse>> getCountryArticles(@PathVariable String code) {
        log.info("get country articles");
        return Response.of(mainService.getCountryArticles(code).stream().map(CountryArticleResponse::fromArticle).collect(Collectors.toList()));
    }


    // 받은 위도, 경도 0.3 반경내 정사각형 범위 기사 500개 조회
    @ApiOperation(value="받은 위도, 경도 0.3 반경내 정사각형 범위 기사 500개 조회", notes="정상 동작 시 'result' return")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 작동"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("/articles/{lat}/{lon}")
    public Response<List<LatLongResponse>> getLatLongArticles(@PathVariable String lat, @PathVariable String lon) {
        log.info("get lat, long +-0.3 articles");

        try {
            Float floatLat = Float.parseFloat(lat);
            Float floatLon = Float.parseFloat(lon);

            return Response.of(mainService.getLatLongArticles(floatLat, floatLon).stream().map(LatLongResponse::fromArticle).collect(Collectors.toList()));
        } catch (NumberFormatException e) { // 잘못된 형식의 데이터
            throw new HastApplicationException();
        }
    }

    // 치안 수치
    @ApiOperation(value="국가 치안 수치 조회", notes="정상 동작 시 'result' return")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 작동"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("/measures/{code}")
    public Response<List<StaticsResponse>> getScore(@PathVariable String code) {
        log.info("get measures");
        return Response.of(mainService.getStatics(code).stream().map(StaticsResponse::fromMeasure).collect(Collectors.toList()));
    }

}

// 1. 치안 점수 조회 (시각화)
// 2. 동그라미 그리는 점수 조회