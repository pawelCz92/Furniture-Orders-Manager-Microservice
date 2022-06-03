package com.pawel.furniturewithcomponentsrepository.domain.configurations.service;

import com.pawel.furniturewithcomponentsrepository.domain.configurations.db.ConfigurationRepo;
import com.pawel.furniturewithcomponentsrepository.domain.configurations.model.Configuration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConfigurationService {

    private final ConfigurationRepo repo;

    public void save(Configuration configuration) {
        log.info("Saving configuration: {}", configuration.getName());
        repo.save(configuration);
        log.info("Saved configuration: {}", configuration);
    }
}
