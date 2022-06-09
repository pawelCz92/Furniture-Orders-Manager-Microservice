package com.pawel.furniturewithcomponentsrepository.domain.element.service;

import com.pawel.furniturewithcomponentsrepository.domain.element.db.ElementRepo;
import com.pawel.furniturewithcomponentsrepository.domain.element.exceptions.ElementAlreadyExistsException;
import com.pawel.furniturewithcomponentsrepository.domain.element.model.Element;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ElementService {

    private final ElementRepo repo;


    public List<Element> findAllElements() {
        return repo.findAll();
    }

    public Element save(Element element) {
        if (findBy(element).isPresent()) {
            throw new ElementAlreadyExistsException("Element: " + element.toShortString()
                    + " already exist. Saving skipped");
        }
        return repo.save(element);
    }

    private Optional<Element> findBy(Element element) {
        return repo.findByFurnitureNameAndMaterial_NameAndLengthAndHeightAndThicknessAndSuffix(
                element.getFurnitureName(),
                element.getMaterial().getName(),
                element.getLength(),
                element.getHeight(),
                element.getThickness(),
                element.getSuffix()
        );
    }
}
