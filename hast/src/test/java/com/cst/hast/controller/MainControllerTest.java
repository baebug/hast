package com.cst.hast.controller;

import com.cst.hast.dto.Article;
import com.cst.hast.dto.Safety;
import com.cst.hast.service.MainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    MainService mainService;

    @Test
    void 최신_기사_목록() throws Exception {
        List<Article> articles = new ArrayList<>();
        articles.add(new Article("Headline 1", "Url 1", "Img 1"));
        articles.add(new Article("Headline 2", "Url 2", "Img 2"));

        when(mainService.getUpdateArticles()).thenReturn(articles);

        mockMvc.perform(get("/api/updates/articles")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void 치안_점수_확인() throws Exception {
        Safety safety = new Safety(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 1888L, 11L, 12L);

        when(mainService.getSafety(any())).thenReturn(safety);

        mockMvc.perform(get("/api/safety/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void 국가_기사_목록() throws Exception {
        List<Article> articles = new ArrayList<>();
        articles.add(new Article("Country Headline 1", "Country Url 1", "Country Img 1"));
        articles.add(new Article("Country Headline 2", "Country Url 2", "Country Img 2"));

        when(mainService.getCountryArticles(any())).thenReturn(articles);

        mockMvc.perform(get("/api/articles/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void 지역_기사_목록() throws Exception {
        List<Article> articles = new ArrayList<>();
        articles.add(new Article("City Headline 1", "City Url 1", "City Img 1"));
        articles.add(new Article("City Headline 2", "City Url 2", "City Img 2"));

        when(mainService.getCityArticles(anyFloat(), anyFloat())).thenReturn(articles);

        mockMvc.perform(get("/api/articles/20.5/10.3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }


}