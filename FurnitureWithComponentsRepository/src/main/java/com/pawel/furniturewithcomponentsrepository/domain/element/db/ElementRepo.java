package com.pawel.furniturewithcomponentsrepository.domain.element.db;

import com.pawel.furniturewithcomponentsrepository.domain.element.model.Element;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementRepo extends MongoRepository<Element, String> {

}
