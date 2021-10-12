package com.codegym.thithmodule4.controller;


import com.codegym.thithmodule4.dto.ResponseMessage;
import com.codegym.thithmodule4.model.City;
import com.codegym.thithmodule4.service.city.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/city")
@CrossOrigin(origins = "*")
public class CityController {


    @Autowired
    ICityService cityService;

    @GetMapping("")
    public ResponseEntity<Iterable<City>> findAll() {
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestParam("id") Optional<Long> id, @RequestBody City city) {
        if (!id.isPresent() && cityService.existsByName(city.getName())) {
            return new ResponseEntity<>(new ResponseMessage("no"), HttpStatus.OK);
        } else if (!id.isPresent() && !cityService.existsByName(city.getName())) {
            cityService.save(city);
        } else {
            City city1 = cityService.findById(id.get()).get();
            city.setId(city1.getId());
            cityService.save(city);
        }

        return new ResponseEntity<>(new ResponseMessage("Save success!"), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        cityService.remove(id);
        return new ResponseEntity<>(new ResponseMessage("Delete success!"), HttpStatus.OK);
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<Optional<City>> findById(@PathVariable("id") Optional<City> city) {

        return new ResponseEntity<>(city, HttpStatus.OK);
    }


}
