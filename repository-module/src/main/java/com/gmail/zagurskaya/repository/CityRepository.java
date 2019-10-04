package com.gmail.zagurskaya.repository;

import com.gmail.zagurskaya.repository.model.City;
/**
 * Интерфейс города
 */
public interface CityRepository extends GenericRepository<Long, City> {
    /**
     * Возвращает город по его названию
     *
     * @param name - название города
     * @return - город
     */
    City loadCityByName(String name);

}
