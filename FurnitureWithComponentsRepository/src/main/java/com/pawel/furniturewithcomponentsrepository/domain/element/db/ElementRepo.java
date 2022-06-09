package com.pawel.furniturewithcomponentsrepository.domain.element.db;

import com.pawel.furniturewithcomponentsrepository.domain.element.model.Element;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElementRepo extends MongoRepository<Element, String> {

    Optional<Element> findByFurnitureNameAndMaterial_NameAndLengthAndHeightAndThicknessAndSuffix(
            String furnitureName, String materialName, int length, int height, int thickness, String suffix
    );
}
