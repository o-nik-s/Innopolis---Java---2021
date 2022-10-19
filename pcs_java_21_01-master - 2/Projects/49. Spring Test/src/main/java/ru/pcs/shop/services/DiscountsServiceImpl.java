package ru.pcs.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pcs.shop.dto.DiscountDto;
import ru.pcs.shop.dto.DiscountsForPricesDto;
import ru.pcs.shop.dto.OrdersPricesDto;
import ru.pcs.shop.exceptions.IncorrectPrice;
import ru.pcs.shop.exceptions.IncorrectType;
import ru.pcs.shop.models.Discount;
import ru.pcs.shop.repositories.DiscountsRepositoryDataJpa;
import ru.pcs.shop.repositories.DiscountsRepositoryJdbc;

import java.util.List;

/**
 * 09.05.2021
 * shop-service
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class DiscountsServiceImpl implements DiscountsService {

    @Autowired
    private DiscountsRepositoryDataJpa discountsRepository;

    @Autowired
    private DiscountsRepositoryJdbc discountsRepositoryJdbc;

    @Override
    public List<DiscountDto> getDiscountsByType(String type) {
        Discount.Type discountType;
        try {
            discountType = Discount.Type.valueOf(type);
        } catch (IllegalArgumentException e) {
            throw new IncorrectType();
        }
        return DiscountDto.from(discountsRepository.findAllByType(discountType));
    }

    @Override
    public DiscountsForPricesDto applyDiscounts(OrdersPricesDto ordersPrices) {
        if (ordersPrices.getPrices().stream().anyMatch(value -> value < 0)) {
            throw new IncorrectPrice("Price must be positive");
        }
        return discountsRepositoryJdbc.applyAllDiscounts(ordersPrices.getPrices());
    }
}
