package com.pawel.furniturewithcomponentsrepository.domain.element.service;

import com.pawel.furniturewithcomponentsrepository.domain.element.db.ElementRepo;
import com.pawel.furniturewithcomponentsrepository.domain.element.model.Element;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ElementService {

    private final ElementRepo repo;


    public List<Element> findAllElements() {
        return repo.findAll();
    }
}
