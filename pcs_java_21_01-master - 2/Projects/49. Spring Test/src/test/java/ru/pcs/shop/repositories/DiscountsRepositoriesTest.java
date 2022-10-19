package ru.pcs.shop.repositories;

import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import ru.pcs.shop.dto.DiscountForPriceDto;
import ru.pcs.shop.dto.DiscountsForPriceDto;
import ru.pcs.shop.dto.DiscountsForPricesDto;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * 18.11.2021
 * 49. Spring Test
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@SpringBootTest
@AutoConfigureEmbeddedDatabase(type = AutoConfigureEmbeddedDatabase.DatabaseType.POSTGRES,
beanName = "dataSource", provider = AutoConfigureEmbeddedDatabase.DatabaseProvider.ZONKY,
        refresh = AutoConfigureEmbeddedDatabase.RefreshMode.BEFORE_EACH_TEST_METHOD)
@Sql(scripts = {"classpath:schema.sql", "classpath:data.sql"})
public class DiscountsRepositoriesTest {

    @Autowired
    private DiscountsRepositoryDataJpa discountsRepositoryDataJpa;

    @Autowired
    private DiscountsRepositoryJdbc discountsRepositoryJdbc;

    @Test
    public void return_correct_prices() {
        DiscountsForPricesDto actual = discountsRepositoryJdbc.applyAllDiscounts(Arrays.asList(100.0, 200.0, 300.0));
        assertThat(actual, is(equalTo(expectedPrices())));
    }

    public static DiscountsForPricesDto expectedPrices() {
        return DiscountsForPricesDto.builder()
                .data(Arrays.asList(
                        DiscountsForPriceDto.builder()
                                .price(100.0)
                                .discounts(Arrays.asList(
                                        DiscountForPriceDto.builder()
                                                .percents(15.0)
                                                .priceByDiscount(85.0)
                                                .build(),
                                        DiscountForPriceDto.builder()
                                                .percents(20.0)
                                                .priceByDiscount(80.0)
                                                .build()))
                                .build(),
                        DiscountsForPriceDto.builder()
                                .price(200.0)
                                .discounts(Arrays.asList(
                                        DiscountForPriceDto.builder()
                                                .percents(15.0)
                                                .priceByDiscount(170.0)
                                                .build(),
                                        DiscountForPriceDto.builder()
                                                .percents(20.0)
                                                .priceByDiscount(160.0)
                                                .build()))
                                .build(),
                        DiscountsForPriceDto.builder()
                                .price(300.0)
                                .discounts(Arrays.asList(
                                        DiscountForPriceDto.builder()
                                                .percents(15.0)
                                                .priceByDiscount(255.0)
                                                .build(),
                                        DiscountForPriceDto.builder()
                                                .percents(20.0)
                                                .priceByDiscount(240.0)
                                                .build()))
                                .build()
                ))
                .build();
    }

    @Test
    public void return_correct_counts_of_discounts() {
        assertThat(discountsRepositoryDataJpa.count(), is(2L));
    }
}
