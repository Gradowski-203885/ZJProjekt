package com.cinema.service;

import com.cinema.model.City;

public interface CityService {
    City getCity(Long id);
    Long updateCity(City city);
    Long addCity(City city);
    void deleteCity(Long id);
}
