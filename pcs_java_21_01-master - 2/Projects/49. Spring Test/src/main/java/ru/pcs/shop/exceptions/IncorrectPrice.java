package ru.pcs.shop.exceptions;

/**
 * 10.05.2021
 * shop-service
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class IncorrectPrice extends RuntimeException {
    public IncorrectPrice(String message) {
        super(message);
    }
}
