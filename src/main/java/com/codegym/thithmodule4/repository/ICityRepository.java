package com.codegym.thithmodule4.repository;

import com.codegym.thithmodule4.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ICityRepository extends CrudRepository<City,Long> {
    Boolean existsByName(String name);
}
