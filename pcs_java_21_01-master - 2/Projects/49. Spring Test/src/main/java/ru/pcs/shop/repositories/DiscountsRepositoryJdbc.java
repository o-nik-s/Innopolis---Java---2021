package ru.pcs.shop.repositories;

import ru.pcs.shop.dto.DiscountsForPricesDto;

import java.util.List;

/**
 * 09.05.2021
 * shop-service
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface DiscountsRepositoryJdbc {
    DiscountsForPricesDto applyAllDiscounts(List<Double> prices);
}
