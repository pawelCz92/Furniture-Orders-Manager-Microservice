package com.pawel.furniturewithcomponentsrepository.domain.furniture.db;

import com.pawel.furniturewithcomponentsrepository.domain.furniture.model.Furniture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FurnitureRepo extends MongoRepository<Furniture, String> {

    Optional<Furniture> findByName(String name);
}
