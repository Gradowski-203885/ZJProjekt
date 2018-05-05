package com.cinema.manager;

import com.cinema.model.City;
import com.cinema.repository.CityRepository;
import com.cinema.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityManager implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public City getCity(Long id) {
        return cityRepository.findOne(id);
    }

    @Override
    public Long updateCity(City city) {
        City toUpdate = cityRepository.findOne(city.getId());
        toUpdate.setName(city.getName());
        toUpdate.setCinemas(city.getCinemas());

        return cityRepository.save(toUpdate).getId();
    }

    @Override
    public Long addCity(City city) {
        return cityRepository.save(city).getId();
    }

    @Override
    public void deleteCity(Long id) {
        cityRepository.delete(id);
    }
}
