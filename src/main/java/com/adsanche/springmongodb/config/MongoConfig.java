package com.adsanche.springmongodb.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

/**
 * Created by adsanche on 23/06/17.
 */
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {

        return "heroes";
    }

    @Override
    public Mongo mongo() throws Exception {

        return new MongoClient("127.0.0.1", 27017);
    }
}
