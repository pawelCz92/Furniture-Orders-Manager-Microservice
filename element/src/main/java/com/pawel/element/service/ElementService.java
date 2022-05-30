package com.pawel.element.service;

import com.pawel.element.db.ElementRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ElementService {

    private final ElementRepo repo;
}
