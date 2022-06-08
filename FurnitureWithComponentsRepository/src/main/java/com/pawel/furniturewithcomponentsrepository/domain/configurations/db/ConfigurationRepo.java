package com.pawel.furniturewithcomponentsrepository.domain.configurations.db;

import com.pawel.furniturewithcomponentsrepository.domain.configurations.model.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepo extends MongoRepository<Configuration, String> {
}
