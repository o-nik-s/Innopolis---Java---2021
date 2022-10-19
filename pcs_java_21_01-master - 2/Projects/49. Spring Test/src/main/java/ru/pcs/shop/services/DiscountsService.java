package ru.pcs.shop.services;

import ru.pcs.shop.dto.DiscountDto;
import ru.pcs.shop.dto.DiscountsForPricesDto;
import ru.pcs.shop.dto.OrdersPricesDto;

import java.util.List;

/**
 * 09.05.2021
 * shop-service
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface DiscountsService {
    List<DiscountDto> getDiscountsByType(String type);

    DiscountsForPricesDto applyDiscounts(OrdersPricesDto ordersPrices);
}
