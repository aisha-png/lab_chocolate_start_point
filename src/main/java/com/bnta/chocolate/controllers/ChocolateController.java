package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("chocolates")
public class ChocolateController {

    @Autowired
    ChocolateRepository chocolateRepository;

//    INDEX

    @GetMapping//localhost:8080/chocolates
    public ResponseEntity<List<Chocolate>> getAllChocolateName(
            @RequestParam(required = false, name = "name") String name){
        return new ResponseEntity<>(chocolateRepository.findAll(), HttpStatus.OK);
    }

//    SHOW ROUTE

    @GetMapping(value = "/{id}")//localhost:8080/chocolates/1
    public ResponseEntity<Optional<Chocolate>> getChocolate(@PathVariable Long id){
        return new ResponseEntity<>(chocolateRepository.findById(id), HttpStatus.OK);
    }

//    POST

    @PostMapping
    public ResponseEntity<Chocolate> createChocolate(@RequestBody Chocolate newChocolate){
        chocolateRepository.save(newChocolate);
        return new ResponseEntity<>(newChocolate, HttpStatus.CREATED);
    }


}

