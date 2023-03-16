package com.cst.hast.controller;


import com.cst.hast.common.ResultDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class MainController {

    @GetMapping("/world")
    public ResponseEntity<?> getWorld() {
        log.info("국가 정보 조회");
        return ResponseEntity.status(200).body(ResultDto.ofSuccess());
    }

    /**
     *
     * @produces (반환 타입)
     */
    @GetMapping(value = "updates/articles", produces = "text/event-stream")
    public ResponseEntity<?> getUpdateArticles() {
        log.info("최신 기사 조회");
        return ResponseEntity.status(200).body(ResultDto.ofSuccess());
    }

    @GetMapping("/eng")
    public ResponseEntity<?> getNationEngInfo() {
        log.info("(ENG) 국가 기본 정보 조회");
        return ResponseEntity.status(200).body(ResultDto.ofSuccess());
    }

    @GetMapping("/kor")
    public ResponseEntity<?> getNationKorInfo() {
        log.info("(KOR) 국가 기본 정보 조회");
        return ResponseEntity.status(200).body(ResultDto.ofSuccess());
    }

    @GetMapping("/safety")
    public ResponseEntity<?> getSafety(@PathVariable String worldId) {
        log.info("치안 점수 조회");
        return ResponseEntity.status(200).body(ResultDto.ofSuccess());
    }

    @GetMapping("/articles/{worldId}")
    public ResponseEntity<?> getNationArticles(@PathVariable String wolrdId) {
        log.info("국가 기사 조회 (각 기사의 ton 정보 포함)");
        return ResponseEntity.status(200).body(ResultDto.ofSuccess());
    }

    @GetMapping("/articles/{lat}/{lon}")
    public ResponseEntity<?> getCityArticles(@PathVariable String lan, @PathVariable String lon) {
        log.info("지역 뉴스 조회");
        return ResponseEntity.status(200).body(ResultDto.ofSuccess());
    }

}
