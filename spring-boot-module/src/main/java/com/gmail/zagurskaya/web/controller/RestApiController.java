package com.gmail.zagurskaya.web.controller;

import com.gmail.zagurskaya.service.CityService;
import com.gmail.zagurskaya.service.model.CityDTO;
import com.gmail.zagurskaya.web.validator.CityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Контроллер
 */
@RestController
@RequestMapping("/api")
public class RestApiController {

    private final CityService cityService;

    /**
     * Конструктор
     */
    @Autowired
    public RestApiController(CityService cityService) {
        this.cityService = cityService;
    }

    /**
     * Сохранение данных города
     *
     * @param city - город
     * @return HttpStatus
     */
    @PostMapping("/city")
    public ResponseEntity saveCity(@RequestBody @Valid CityDTO city) {
        if (CityValidation.isEmptyCityData(city)) {
            cityService.add(city);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Обновление данных города
     *
     * @param city - город
     * @return HttpStatus
     */
    @PutMapping("/city")
    public ResponseEntity updateCity(@RequestBody @Valid CityDTO city) {
        if (CityValidation.isEmptyCityData(city)) {
            cityService.update(city);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Удаление города
     *
     * @param city - город
     * @return HttpStatus
     */
    @DeleteMapping("/city")
    public ResponseEntity deleteCity(@RequestBody @Valid CityDTO city) {
        if (CityValidation.isEmptyCityData(city)) {
            cityService.delete(city);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
