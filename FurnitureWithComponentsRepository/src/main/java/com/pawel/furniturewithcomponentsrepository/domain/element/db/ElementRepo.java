package com.pawel.furniturewithcomponentsrepository.domain.element.db;

import com.pawel.furniturewithcomponentsrepository.domain.element.model.Element;
import com.pawel.furniturewithcomponentsrepository.domain.material.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElementRepo extends JpaRepository<Element, Long> {


    Optional<Element> findByLengthAndHeightAndThicknessAndSuffixAndDescriptionAndMaterial(
            int length, int height, int thickness, String suffix, String description, Material material);
    // //TODO change to hql query
}
