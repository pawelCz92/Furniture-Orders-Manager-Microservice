package com.pawel.furniturewithcomponentsrepository.domain.material.db;

import com.pawel.furniturewithcomponentsrepository.domain.material.model.Material;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaterialRepo extends MongoRepository<Material, String> {

    Optional<Material> findByName(String name);
}
