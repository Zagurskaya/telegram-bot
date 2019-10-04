package com.gmail.zagurskaya.repository;

/**
 * Интерфейс
 */
public interface GenericRepository<I, T> {
    /**
     * Добавление объекта
     *
     * @param entity - объект
     */
    void persist(T entity);

    /**
     * Обновление объекта
     *
     * @param entity - объект
     */
    void merge(T entity);

    /**
     * Удаление объекта
     *
     * @param entity - объект
     */
    void remove(T entity);

    /**
     * Поиск объекта по Id
     *
     * @param id - объект
     * @return - объект
     */
    T findById(I id);

    /**
     * Возвращает объект по Id
     *
     * @param id - объект
     * @return - объект
     */
    T getById(I id);
}
