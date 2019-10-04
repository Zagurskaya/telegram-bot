package com.gmail.zagurskaya.service;

import com.gmail.zagurskaya.service.model.CityDTO;

/**
 * Сервис города.
 */
public interface CityService {
    /**
     * Добавление города
     *
     * @param city - город
     */
    void add(CityDTO city);

    /**
     * Удаление города
     *
     * @param city - город
     */
    void delete(CityDTO city);

    /**
     * Обновление города
     *
     * @param city - город
     */
    void update(CityDTO city);

    /**
     * Получение города по названию города
     *
     * @param name - название города
     */
    CityDTO loadCityByName(String name);

}
