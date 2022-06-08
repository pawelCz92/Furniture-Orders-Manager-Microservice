package com.pawel.furniturewithcomponentsrepository.domain.furniture.db;

import com.pawel.furniturewithcomponentsrepository.domain.furniture.model.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FurnitureRepo extends JpaRepository<Furniture, Long> {

    Optional<Furniture> findByName(String name);
}
