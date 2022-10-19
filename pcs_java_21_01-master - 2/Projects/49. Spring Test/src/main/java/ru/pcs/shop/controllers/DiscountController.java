package ru.pcs.shop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pcs.shop.dto.DiscountDto;
import ru.pcs.shop.dto.DiscountsForPricesDto;
import ru.pcs.shop.dto.ExceptionDto;
import ru.pcs.shop.dto.OrdersPricesDto;
import ru.pcs.shop.exceptions.IncorrectPrice;
import ru.pcs.shop.services.DiscountsService;

import java.util.List;

/**
 * 09.05.2021
 * shop-service
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RestController
@RequiredArgsConstructor
public class DiscountController {

    private final DiscountsService discountsService;

    @GetMapping("/discounts")
    public ResponseEntity<List<DiscountDto>> getDiscountsByType(@RequestParam("type") String type) {
        return ResponseEntity.ok(discountsService.getDiscountsByType(type));
    }

    @PostMapping(value = "/discounts/apply", params = "type=PERCENTS")
    public ResponseEntity<DiscountsForPricesDto> applyDiscounts(@RequestBody OrdersPricesDto ordersPrices) {
        return ResponseEntity.ok(discountsService.applyDiscounts(ordersPrices));
    }

    @ExceptionHandler(IncorrectPrice.class)
    public ResponseEntity<ExceptionDto> handleIncorrectType(IncorrectPrice exception) {
        return ResponseEntity.badRequest()
                .body(ExceptionDto.builder()
                        .code(HttpStatus.BAD_REQUEST.value())
                        .message(exception.getMessage())
                        .build());
    }
}
