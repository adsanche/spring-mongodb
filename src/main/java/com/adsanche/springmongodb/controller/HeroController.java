package com.adsanche.springmongodb.controller;

import com.adsanche.springmongodb.entity.Hero;
import com.adsanche.springmongodb.service.IHeroService;
import com.adsanche.springmongodb.util.BadParametersException;
import com.adsanche.springmongodb.util.HeroNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by adsanche on 20/06/17.
 */
@Api(value = "/heroes", description = "Service managing operations linked to the heroes")
@RestController
public class HeroController {

    @Autowired
    private IHeroService heroService;

    @ApiOperation(value = "Get all the heroes", response = Hero.class, responseContainer = "List")
    @GetMapping(value = "/heroes")
    public ResponseEntity<List<Hero>> getAllHeroes() {

        return new ResponseEntity<>(this.heroService.getAllHeroes(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get a hero by his ID", response = Hero.class)
    @GetMapping("/heroes/{id}")
    public ResponseEntity<Hero> getHeroById(@PathVariable final String id)
            throws BadParametersException, HeroNotFoundException {

        return new ResponseEntity<>(this.heroService.getHeroById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Get a hero by his name", response = Hero.class)
    @GetMapping(value = "/heroes", params = "heroname")
    public ResponseEntity<Hero> getHeroByHeroName(@RequestParam(value = "heroname") final String heroName)
            throws BadParametersException, HeroNotFoundException {

        return new ResponseEntity<>(this.heroService.getHeroByHeroName(heroName), HttpStatus.OK);
    }
}
