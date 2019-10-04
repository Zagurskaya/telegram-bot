package com.gmail.zagurskaya.repository.impl;

import com.gmail.zagurskaya.repository.CityRepository;
import com.gmail.zagurskaya.repository.model.City;

import org.springframework.stereotype.Repository;

import javax.persistence.Query;

/**
 * Реализация интерфейса города
 */
@Repository
public class CityRepositoryImpl extends GenericRepositoryImpl<Long, City> implements CityRepository {
    /**
     * Возвращает город по его названию
     *
     * @param name - название города
     * @return - город
     */
    @Override
    public City loadCityByName(String name) {
        String query = "select u from  City u WHERE u.name like :name";
        Query q = entityManager.createQuery(query).setParameter("name", name);
        return (City) q.getSingleResult();
    }

}
