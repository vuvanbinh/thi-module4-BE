package com.codegym.thithmodule4.service.city;

import com.codegym.thithmodule4.model.City;
import com.codegym.thithmodule4.repository.ICityRepository;
import com.codegym.thithmodule4.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class CityService implements ICityService {

    @Autowired
    private ICityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void remove(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public Boolean existsByName(String name) {
        return cityRepository.existsByName(name);
    }
}
