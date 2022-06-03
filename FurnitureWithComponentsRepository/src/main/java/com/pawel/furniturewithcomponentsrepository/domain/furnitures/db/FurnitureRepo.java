package com.pawel.furniturewithcomponentsrepository.domain.furnitures.db;

import com.pawel.furniturewithcomponentsrepository.domain.furnitures.model.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FurnitureRepo extends JpaRepository<Furniture, Long> {

    Optional<Furniture> findByName(String name);
}
