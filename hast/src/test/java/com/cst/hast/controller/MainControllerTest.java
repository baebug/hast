//package com.cst.hast.controller;
//
//import com.cst.hast.dto.response.UpdateArticleResponse;
//import com.cst.hast.service.MainServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest // @Controller, @RestController가 설정된 클래스들을 찾아 메모리에 생성
//class MainControllerTest {
//    @Autowired
//    MockMvc mockMvc; // 서블릿 컨테이너가 없는 가상의 서버를 제공하여 HTTP 요청 및 응답을 시뮬레이션 가능
////    @MockBean // Bean 객체 Mocking
////    MainServiceImpl mainService;
//    @Autowired
//    MainController mainController;
//
//    List<UpdateArticleResponse> updateArticleList = new ArrayList<>();
//
//    @BeforeEach
//    void setUp() {
//        // MockMvc
//        mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
//
//        // MockMembers
////        updateArticleList.add(UpdateArticleResponse.builder().headline("정원웅").url("www.com").build());
////        updateArticleList.add(UpdateArticleResponse.builder().headline("성정언").url("2222").build());
//    }
//
//    @Test
//    @DisplayName("국가 정보 조회") // test code 실행할 때 보여지는 이름
//    void getWorld() throws Exception {
//
//        List<UpdateArticleResponse> list = new ArrayList<>();
//
//        // given
////        given(mainService.getUpdateArticles()).willReturn(list);
//
//        // when
//        ResultActions actions = mockMvc.perform(get("/world"));
//
//        // then
//        actions.andDo(print()) // 요청과 응답에 관한 내용 출력
//                .andExpect(status().isOk()) // status 코드 검증
//                .andExpect(jsonPath("[0].headline").value("정원웅"))
//                .andExpect(jsonPath("[0].url").value("www.com"));
//
//
//        // verify
////        verify(mainService, times(1)).getUpdateArticles();
//
//    }
//
//
//
//
//}