package com.pawel.furniturewithcomponentsrepository.domain.utils;

import com.pawel.furniturewithcomponentsrepository.domain.configurations.service.ConfigurationService;
import com.pawel.furniturewithcomponentsrepository.domain.element.model.Element;
import com.pawel.furniturewithcomponentsrepository.domain.element.service.ElementService;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.model.Furniture;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.service.FurnitureService;
import com.pawel.furniturewithcomponentsrepository.domain.material.model.Material;
import com.pawel.furniturewithcomponentsrepository.domain.material.service.MaterialService;
import com.pawel.furniturewithcomponentsrepository.domain.part.service.PartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    private final ElementService elementService;
    private final PartService partService;
    private final ConfigurationService configurationService;
    private final FurnitureService furnitureService;
    private final MaterialService materialService;


    @EventListener(ContextRefreshedEvent.class)
    public void handleContextRefresh(ContextRefreshedEvent event) {
        // elementService.findAllElements().forEach(System.out::println);
        log.info("------------------> method handle ContextRefresh");
        Set<String> linesFromFile = new HashSet<>(Objects.requireNonNull(readLinesFromFile()));
        readAndSaveDataFromLines(linesFromFile);
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
        return null;
    }

    private void readAndSaveDataFromLines(Set<String> lines) {
        List<String[]> splitedLines = lines.stream()
                .map(line -> line.split(","))
                .collect(Collectors.toList());

        Set<Element> elements = new HashSet<>();

        String model;
        String material;
        String length;
        String hight;
        String thickness;
        String suffix;

        for (int i = 0; i < splitedLines.size(); i++) {
            String[] strings = splitedLines.get(i);
            if (strings.length == 5) {
                model = strings[0];
                material = strings[1];
                length = strings[2];
                hight = strings[3];
                thickness = strings[4];
                // suffix = strings[5];
            } else {
                model = strings[0];
                material = strings[1];
                length = strings[2];
                hight = strings[3];
                thickness = strings[4];
                suffix = strings[5];
            }

        }
        elements.add(Element.builder()
                //          .furniture()

                .build());
        System.out.println();
    }

    private Material saveMaterialIfNotExist(String name) {
        Optional<Material> materialOpt = materialService.findMaterialByName(name);
        if (materialOpt.isEmpty()) {
            materialService.save(new Material(null, name));
        }
        return materialService.findMaterialByName(name).get();

    }

    private Furniture saveFurnitureIfNotExist(String name) {
        Optional<Furniture> furnitureOpt = furnitureService.findFurnitureByName(name);
        if (furnitureOpt.isEmpty()) {
            furnitureService.save(Furniture.builder()
                    .name(name)
                    .build());
        }
        return furnitureService.findFurnitureByName(name).get();
    }
}
