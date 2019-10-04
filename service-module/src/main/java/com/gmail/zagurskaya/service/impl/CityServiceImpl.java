package com.gmail.zagurskaya.service.impl;

import com.gmail.zagurskaya.repository.CityRepository;
import com.gmail.zagurskaya.repository.model.City;
import com.gmail.zagurskaya.service.CityService;
import com.gmail.zagurskaya.service.converter.CityConverter;
import com.gmail.zagurskaya.service.model.CityDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Реализация сервиса города.
 */
@Service
@Transactional
public class CityServiceImpl implements CityService {

    private final CityConverter cityConverter;
    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityConverter cityConverter, CityRepository cityRepository) {
        this.cityConverter = cityConverter;
        this.cityRepository = cityRepository;
    }

    /**
     * Добавление города
     *
     * @param cityDTO - город
     */
    @Override
    @Transactional
    public void add(CityDTO cityDTO) {
        City city = cityConverter.toEntity(cityDTO);
        cityRepository.persist(city);
    }

    /**
     * Удаление города
     *
     * @param cityDTO - город
     */
    @Override
    @Transactional
    public void delete(CityDTO cityDTO) {
        City deleteCity = cityRepository.loadCityByName(cityDTO.getName());
        if (cityRepository.findById(deleteCity.getId()) != null) {
            cityRepository.remove(deleteCity);
        }
    }

    /**
     * Обновление города
     *
     * @param cityDTO - город
     */
    @Override
    @Transactional
    public void update(CityDTO cityDTO) {
        City updateCity = cityRepository.loadCityByName(cityDTO.getName());
        updateCity.setName(cityDTO.getName());
        updateCity.setDescription(cityDTO.getDescription());
        cityRepository.merge(updateCity);
    }

    /**
     * Получение города по названию города
     *
     * @param name - название города
     */
    @Transactional
    public CityDTO loadCityByName(String name) {
        try {
            City loaded = cityRepository.loadCityByName(name);
            CityDTO cityDTO = cityConverter.toDTO(loaded);
            return cityDTO;
        } catch (EmptyResultDataAccessException e) {
            CityDTO emptyCity = new CityDTO();
            emptyCity.setDescription("Нет данных о городе");
            return emptyCity;
        }

    }
}
