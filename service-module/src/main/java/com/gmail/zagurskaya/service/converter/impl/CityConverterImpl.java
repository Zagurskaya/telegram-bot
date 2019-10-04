package com.gmail.zagurskaya.service.converter.impl;

import com.gmail.zagurskaya.repository.CityRepository;
import com.gmail.zagurskaya.repository.model.City;
import com.gmail.zagurskaya.service.converter.CityConverter;
import com.gmail.zagurskaya.service.model.CityDTO;
import org.springframework.stereotype.Component;

/**
 * Реализация конвертора города
 */
@Component
public class CityConverterImpl implements CityConverter {

    private final CityRepository cityRepository;

    /**
     * Конструктор
     */
    public CityConverterImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    /**
     * Конвертирование города в DTO города
     *
     * @param city - город
     * @return DTO города
     */
    @Override
    public CityDTO toDTO(City city) {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(city.getId());
        cityDTO.setName(city.getName());
        cityDTO.setDescription(city.getDescription());

        return cityDTO;
    }

    /**
     * Конвертирование DTO города в города
     *
     * @param cityDTO - DTO города
     * @return город
     */
    @Override
    public City toEntity(CityDTO cityDTO) {
        City city = new City();
        city.setId(cityDTO.getId());
        city.setName(cityDTO.getName());
        city.setDescription(cityDTO.getDescription());
        return city;
    }
}
