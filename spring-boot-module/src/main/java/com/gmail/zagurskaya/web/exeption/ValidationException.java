package com.gmail.zagurskaya.web.exeption;

/**
 * Ошибка валидации
 *
 */
public class ValidationException extends RuntimeException {
    /**
     * Конструктор
     *
     * @param message - сообщение
     */
    public ValidationException(String message) {

        super(message);
    }

}
