package com.pawel.furniturewithcomponentsrepository.domain.part.db;

import com.pawel.furniturewithcomponentsrepository.domain.part.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartRepo extends JpaRepository<Part, Long> {

    Optional<Part> findByName(String name);
}
