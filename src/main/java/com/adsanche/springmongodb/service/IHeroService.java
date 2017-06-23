package com.adsanche.springmongodb.service;

import com.adsanche.springmongodb.entity.Hero;
import com.adsanche.springmongodb.util.BadParametersException;
import com.adsanche.springmongodb.util.HeroNotFoundException;

import java.util.List;

/**
 * Created by adsanche on 21/06/17.
 */
public interface IHeroService {

    List<Hero> getAllHeroes();

    Hero getHeroById(String id) throws BadParametersException, HeroNotFoundException;

    Hero getHeroByHeroName(String heroName) throws BadParametersException, HeroNotFoundException;
}
