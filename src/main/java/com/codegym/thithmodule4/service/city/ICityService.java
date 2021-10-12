package com.codegym.thithmodule4.service.city;

import com.codegym.thithmodule4.model.City;
import com.codegym.thithmodule4.service.IService;
import org.springframework.stereotype.Service;

@Service
public interface ICityService extends IService<City> {
    Boolean existsByName(String name);
}
