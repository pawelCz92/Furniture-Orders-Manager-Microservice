package com.pawel.furniturewithcomponentsrepository.domain.utils;

import com.pawel.furniturewithcomponentsrepository.domain.element.model.Element;
import com.pawel.furniturewithcomponentsrepository.domain.element.service.ElementService;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.model.Furniture;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.service.FurnitureService;
import com.pawel.furniturewithcomponentsrepository.domain.material.model.Material;
import com.pawel.furniturewithcomponentsrepository.domain.material.service.MaterialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
@Slf4j
public class FurnitureGenerator {

    private static final String ELEMENTS_CSV_FILE_NAME = "elements.csv";
    private static final String SPLIT_REGEX = ";";


    private final FurnitureService furnitureService;
    private final MaterialService materialService;
    private final ElementService elementService;


    @EventListener(ContextRefreshedEvent.class)
    public void handleContextRefresh(ContextRefreshedEvent event) {
        log.info("------------------> method handle ContextRefresh");
        long elementsNr = elementService.findAllElements().size();
        Set<String> linesFromFile = new HashSet<>(readLinesFromFile());
        if (elementsNr == linesFromFile.size()) {
            log.info("There is {} elements in base, and lines with data: {} - saving skipped!", elementsNr,
                    linesFromFile.size());
            return;
        }
        Set<Element> elements = readElementsFromCsvLines(linesFromFile);
        elements.forEach(System.out::println);
        saveElements(elements).forEach(System.out::println);

        log.info("------------------>  STOP method handle ContextRefresh");
    }

    private List<String> readLinesFromFile() {
        Stream<String> lines = null;
        try {
            Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                    .getResource(ELEMENTS_CSV_FILE_NAME)).toURI());
            lines = Files.lines(path);
            return lines
                    .skip(1)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert lines != null;
            lines.close();
        }
        return new ArrayList<>();
    }

    private Set<Element> readElementsFromCsvLines(Set<String> lines) {
        List<String[]> splitedLines = lines.stream()
                .map(line -> line.split(SPLIT_REGEX)).toList();

        Set<Element> elements = new HashSet<>();

        String model;
        String material;
        String length;
        String hight;
        String thickness;
        String suffix;
        String descr;

        for (String[] strings : splitedLines) {
            if (strings.length == 6) {
                model = strings[1];
                material = strings[2];
                length = strings[3];
                hight = strings[4];
                thickness = strings[5];
                suffix = null;
                descr = null;
            } else if (strings.length == 7) {
                model = strings[1];
                material = strings[2];
                length = strings[3];
                hight = strings[4];
                thickness = strings[5];
                suffix = strings[6];
                descr = null;
            } else {
                model = strings[1];
                material = strings[2];
                length = strings[3];
                hight = strings[4];
                thickness = strings[5];
                suffix = strings[6];
                descr = strings[7];
            }

            Element element = Element.builder()
                    .furnitureName(saveFurnitureIfNotExist(model))
                    .material(saveMaterialIfNotExist(material))
                    .length(Integer.parseInt(length))
                    .height(Integer.parseInt(hight))
                    .thickness(Integer.parseInt(thickness))
                    .suffix(suffix)
                    .description(descr)
                    .build();

            elements.add(element);
        }
        return elements;
    }

    private String saveFurnitureIfNotExist(String name) {
        Optional<Furniture> furnitureOpt = furnitureService.findFurnitureByName(name);
        if (furnitureOpt.isEmpty()) {
            return furnitureService.save(Furniture.builder()
                            .name(name)
                            .build())
                    .getName();
        }
        return furnitureOpt.get().getName();
    }

    private Material saveMaterialIfNotExist(String name) {
        Optional<Material> materialOpt = materialService.findMaterialByName(name);
        if (materialOpt.isEmpty()) {
            return materialService.save(new Material(null, name));
        }
        return materialOpt.get();
    }


    private List<Element> saveElements(Set<Element> elements) {
        return elements.stream()
                .map(element -> {
                    try {
                        // String materialId = saveMaterialIfNotExist(element.getMaterialId());
                        //   String furnitureId = saveFurnitureIfNotExist(element.getFurnitureId());
                        return elementService.save(
                                Element.builder()
                                        .furnitureName(element.getFurnitureName())
                                        .material(element.getMaterial())
                                        .length(element.getLength())
                                        .height(element.getHeight())
                                        .thickness(element.getThickness())
                                        .suffix(element.getSuffix())
                                        .description(element.getDescription())
                                        .build());
                    } catch (Exception e) {
                        log.warn(e.getMessage());
                    }
                    return null;
                })
                .collect(Collectors.toList());
    }
}
