package com.gmail.zagurskaya.repository.impl;

import com.gmail.zagurskaya.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.lang.reflect.ParameterizedType;

/**
 * Реализация интерфейса Репазитория
 */
public class GenericRepositoryImpl<I, T> implements GenericRepository<I, T> {

    protected Class<T> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    private DataSource dataSource;

    /**
     * Конструктор
     */
    @SuppressWarnings("unchecked")
    public GenericRepositoryImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[1];
    }

    /**
     * Добавление объекта
     *
     * @param entity - объект
     */
    @Override
    public void persist(T entity) {
        entityManager.persist(entity);
    }

    /**
     * Обновление объекта
     *
     * @param entity - объект
     */
    @Override
    public void merge(T entity) {
        entityManager.merge(entity);
    }

    /**
     * Удаление объекта
     *
     * @param entity - объект
     */
    @Override
    public void remove(T entity) {
        entityManager.remove(entity);
    }

    /**
     * Поиск объекта по Id
     *
     * @param id - объект
     * @return - объект
     */
    @Override
    public T findById(I id) {
        return entityManager.find(entityClass, id);
    }

    /**
     * Возвращает объект по Id
     *
     * @param id - объект
     * @return - объект
     */
    @Override
    public T getById(I id) {
        T t = findById(id);
        if (t == null) {
            throw new EntityNotFoundException("Entity with id " + id + " not found");
        }
        return t;
    }


}


