package com.pawel.furniturewithcomponentsrepository.domain.part.db;

import com.pawel.furniturewithcomponentsrepository.domain.part.model.Part;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepo extends MongoRepository<Part, String> {

}
