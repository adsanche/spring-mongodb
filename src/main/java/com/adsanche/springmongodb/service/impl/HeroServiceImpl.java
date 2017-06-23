package com.adsanche.springmongodb.service.impl;

import com.adsanche.springmongodb.entity.Hero;
import com.adsanche.springmongodb.repository.IHeroRepository;
import com.adsanche.springmongodb.service.IHeroService;
import com.adsanche.springmongodb.util.BadParametersException;
import com.adsanche.springmongodb.util.HeroNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by adsanche on 21/06/17.
 */
@Service
public class HeroServiceImpl implements IHeroService {

    @Autowired
    private IHeroRepository heroRepository;

    @Override
    public List<Hero> getAllHeroes() {

        return this.heroRepository.findAll();
    }

    @Override
    public Hero getHeroById(final String id) throws BadParametersException, HeroNotFoundException {

        if (StringUtils.isEmpty(id)) {
            throw new BadParametersException("Hero ID cannot be empty");
        }

        final Hero hero = this.heroRepository.findOne(id);

        if (hero == null) {
            throw new HeroNotFoundException("Hero not found - Hero ID: " + id);
        }

        return hero;
    }

    @Override
    public Hero getHeroByHeroName(final String heroName) throws BadParametersException, HeroNotFoundException {

        if (StringUtils.isEmpty(heroName)) {
            throw new BadParametersException("Hero name cannot be empty");
        }

        final Hero hero = this.heroRepository.findByHeroName(heroName);

        if (hero == null) {
            throw new HeroNotFoundException("Hero not found - Hero name: " + heroName);
        }

        return hero;
    }
}
