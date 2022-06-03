package com.pawel.furniturewithcomponentsrepository.domain.configurations.db;

import com.pawel.furniturewithcomponentsrepository.domain.configurations.model.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepo extends JpaRepository<Configuration, Long> {
}
