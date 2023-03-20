package com.cst.hast.service;

import com.cst.hast.dto.Article;
import com.cst.hast.exception.ErrorCode;
import com.cst.hast.exception.HastApplicationException;
import com.cst.hast.repository.ArticleRepository;
import com.cst.hast.repository.GkgRepository;
import com.cst.hast.repository.MentionRepository;
import com.cst.hast.repository.SafetyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

@SpringBootTest
public class MainServiceTest {

    @Autowired
    MainService mainService;

    @MockBean
    MentionRepository mentionRepository;
    @MockBean
    ArticleRepository articleRepository;
    @MockBean
    GkgRepository gkgRepository;
    @MockBean
    SafetyRepository safetyRepository;

    @Test
    void 최신_기사_목록_요청_성공() {
        when(articleRepository.findAll()).thenReturn(Collections.emptyList());
        Assertions.assertDoesNotThrow(() -> mainService.getUpdateArticles());
    }

    @Test
    void 국가_기사_목록_요청_성공() {
        when(articleRepository.findAllByWorldId(1L)).thenReturn(Collections.emptyList());
        Assertions.assertDoesNotThrow(() -> mainService.getCountryArticles(1L));
    }

    @Test
    void 지역_기사_목록_요청_성공() {
        when(articleRepository.findAllByLatitudeAndLongitude(-20.0F, 20.3F)).thenReturn(Collections.emptyList());
        Assertions.assertDoesNotThrow(() -> mainService.getCityArticles(-20.0F, 20.3F));
    }

    @Test
    void 치안_점수_없을_시_에러_반환() {
        when(safetyRepository.findById(1L)).thenThrow(new HastApplicationException(ErrorCode.SAFETY_NOT_FOUND, String.format("safety of %d is not founded", 1L)));
        HastApplicationException exception = Assertions.assertThrows(HastApplicationException.class, () -> mainService.getSafety(1L));

        Assertions.assertEquals(ErrorCode.SAFETY_NOT_FOUND, exception.getErrorCode());
    }

}
