package ru.pcs.shop.controllers;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.pcs.shop.dto.*;
import ru.pcs.shop.exceptions.IncorrectType;
import ru.pcs.shop.services.DiscountsService;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

/**
 * 18.11.2021
 * 49. Spring Test
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@DisplayName("DiscountsController is working when")
class DiscountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DiscountsService discountsService;

    @BeforeEach
    public void setUp() {
        when(discountsService.getDiscountsByType("PERCENTS")).thenReturn(Collections.singletonList(
                DiscountDto.builder()
                        .description("TEST DESCRIPTION 1")
                        .value(10.0)
                        .type("PERCENTS")
                        .build()));

        when(discountsService.getDiscountsByType("BONUS")).thenReturn(Collections.singletonList(
                DiscountDto.builder()
                        .description("TEST DESCRIPTION 2")
                        .value(50.0)
                        .type("BONUS")
                        .build()));

        when(discountsService.getDiscountsByType("FAKE")).thenThrow(IncorrectType.class);

        when(discountsService.applyDiscounts(OrdersPricesDto.builder()
                .prices(Collections.singletonList(10.0))
                .build()))
                .thenReturn(DiscountsForPricesDto.builder()
                        .data(Collections.singletonList(
                                DiscountsForPriceDto.builder()
                                        .price(10.0)
                                        .discounts(Collections.singletonList(
                                                DiscountForPriceDto.builder()
                                                        .priceByDiscount(9.0)
                                                        .percents(1.0)
                                                        .build()))
                                        .build()))
                        .build());
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    @DisplayName("getDiscountByType() is working")
    class GetDiscountsTest {
        @Test
        public void return_percents_discounts() throws Exception {
            mockMvc.perform(get("/discounts")
                            .param("type", "PERCENTS"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].type", is("PERCENTS")))
                    .andExpect(jsonPath("$[0].value", is(10.0)))
                    .andExpect(jsonPath("$[0].description", is("TEST DESCRIPTION 1")));
        }

        @Test
        public void throws_when_incorrect_type() throws Exception {
            mockMvc.perform(get("/discounts").param("type", "FAKE"))
                    .andDo(print())
                    .andExpect(status().isBadRequest());
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    @DisplayName("applyDiscounts() is working")
    class ApplyDiscountsTest {
        @Test
        public void return_correct_prices() throws Exception {
            mockMvc.perform(post("/discounts/apply")
                    .param("type", "PERCENTS")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{ \n" +
                                            "\"prices\" : [10.0] \n" +
                            "}"))
                    .andDo(print());
        }
    }

}