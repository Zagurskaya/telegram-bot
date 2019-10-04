package com.gmail.zagurskaya.service.converter;

import com.gmail.zagurskaya.repository.model.City;
import com.gmail.zagurskaya.service.model.CityDTO;

/**
 * Конвертор города
 */
public interface CityConverter {
    /**
     * Конвертирование города в DTO города
     *
     * @param city - город
     * @return DTO города
     */
    CityDTO toDTO(City city);

    /**
     * Конвертирование DTO города в города
     *
     * @param cityDTO - DTO города
     * @return город
     */
    City toEntity(CityDTO cityDTO);

}
