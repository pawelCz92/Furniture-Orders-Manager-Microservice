package com.pawel.furniturewithcomponentsrepository.domain.element.service;

import com.pawel.furniturewithcomponentsrepository.domain.element.db.ElementRepo;
import com.pawel.furniturewithcomponentsrepository.domain.element.exceptions.ElementAlreadyExistsException;
import com.pawel.furniturewithcomponentsrepository.domain.element.model.Element;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ElementService {

    private final ElementRepo repo;

    @Transactional
    public void save(Element element) {
        log.info("Saving element: {}", element.toShortString());
        if (findByElement(element).isPresent()) {
            log.warn("Element: {}, already exists.", element.toShortString());
            throw new ElementAlreadyExistsException("Element already exists");
        }
        repo.save(element);
        log.info("Element: {} successfully added to database.", element);
    }

    private Optional<Element> findByElement(Element element) {
        return repo.findByLengthAndHeightAndThicknessAndSuffixAndDescriptionAndMaterial(element.getLength(),
                element.getHeight(), element.getThickness(), element.getSuffix(), element.getDescription(),
                element.getMaterial());
    }

    public List<Element> findAllElements() {
        return repo.findAll();
    }
}
