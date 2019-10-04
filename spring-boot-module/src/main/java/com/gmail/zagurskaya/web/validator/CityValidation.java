package com.gmail.zagurskaya.web.validator;

import com.gmail.zagurskaya.service.model.CityDTO;
import com.gmail.zagurskaya.web.exeption.ValidationException;

/**
 * Валидатор данных
 */
public class CityValidation {

    /**
     * Проверка поля типу String
     *
     * @param cityDTO - город
     * @throws ValidationException при пустых данных
     */
    public static boolean isEmptyCityData(CityDTO cityDTO) {
        if (cityDTO.getName() != null || cityDTO.getDescription() != null) {
            return true;
        } else {
            throw new ValidationException("Пустые данные города");
        }
    }

    /**
     * Проверка поля типу String
     *
     * @param cityDTO - город
     * @throws ValidationException при пустых данных
     */
    public static boolean isEmptyCityName(CityDTO cityDTO) {
        if (cityDTO.getName() != null) {
            return true;
        } else {
            throw new ValidationException("Пустое имя города");
        }
    }
}
