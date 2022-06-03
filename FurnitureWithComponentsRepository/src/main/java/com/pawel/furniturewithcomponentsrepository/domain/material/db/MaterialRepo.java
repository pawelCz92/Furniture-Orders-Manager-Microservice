package com.pawel.furniturewithcomponentsrepository.domain.material.db;

import com.pawel.furniturewithcomponentsrepository.domain.material.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaterialRepo extends JpaRepository<Material, Long> {

    Optional<Material> findByName(String name);
}
