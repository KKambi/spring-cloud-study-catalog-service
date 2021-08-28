package com.example.catalogservice.service;

import com.example.catalogservice.domain.Catalog;
import com.example.catalogservice.domain.CatalogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CatalogService {

    private final CatalogRepository catalogRepository;

    public Iterable<Catalog> getAllCatalogs() {
        return catalogRepository.findAll();
    }
}
