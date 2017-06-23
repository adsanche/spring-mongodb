package com.adsanche.springmongodb.repository;

import com.adsanche.springmongodb.entity.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by adsanche on 20/06/17.
 */
public interface IHeroRepository extends MongoRepository<Hero, String> {

    Hero findByHeroName(String heroName);
}
