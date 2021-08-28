package com.example.catalogservice.api;

import com.example.catalogservice.domain.Catalog;
import com.example.catalogservice.service.CatalogService;
import com.example.catalogservice.vo.ResponseCatalog;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/catalog-service")
public class CatalogController {

    private final Environment env;
    private final CatalogService catalogService;

    @GetMapping("/health-check")
    public String status() {
        return String.format("User Service Working: port(%s)",
                env.getProperty("local.server.port"));
    }

    @GetMapping("/catalogs")
    public ResponseEntity<List<ResponseCatalog>> getAllCatalogs() {
        Iterable<Catalog> catalogs =  catalogService.getAllCatalogs();

        List<ResponseCatalog> result = new ArrayList<>();
        catalogs.forEach(catalog -> result.add(new ModelMapper().map(catalog, ResponseCatalog.class)));

        return ResponseEntity.ok(result);
    }
}
