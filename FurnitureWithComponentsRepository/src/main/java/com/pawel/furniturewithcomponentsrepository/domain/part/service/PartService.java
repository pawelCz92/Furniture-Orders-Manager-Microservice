package com.pawel.furniturewithcomponentsrepository.domain.part.service;

import com.pawel.furniturewithcomponentsrepository.domain.part.db.PartRepo;
import com.pawel.furniturewithcomponentsrepository.domain.part.model.Part;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PartService {

    private final PartRepo repo;


    public void save(Part part) {
        log.info("Saving part: " + part);
        repo.save(part);
        log.info("Saved part: " + part);
    }
}
