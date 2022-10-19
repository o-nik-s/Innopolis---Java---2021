package ru.pcs.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 09.05.2021
 * shop-service
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrdersPricesDto {
    private List<Double> prices;
}
