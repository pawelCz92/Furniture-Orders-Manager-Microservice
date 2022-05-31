package com.pawel.element.service;

import com.pawel.element.db.MaterialRepo;
import com.pawel.element.model.Material;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MaterialService {

    private final MaterialRepo repo;

    @Transactional
    public void save(Material material) {
        log.info("Saving material: {}", material.getName());
        repo.save(material);
        log.info("Saved material: {}", material);
    }

    public List<Material> findAll() {
        return repo.findAll();
    }
}
