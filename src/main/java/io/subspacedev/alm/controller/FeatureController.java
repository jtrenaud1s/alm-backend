package io.subspacedev.alm.controller;

import io.subspacedev.alm.dto.FeatureDto;
import io.subspacedev.alm.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/features")
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    @PostMapping
    public ResponseEntity<FeatureDto> createFeature(@RequestBody FeatureDto featureDto) {
        FeatureDto createdFeature = featureService.createFeature(featureDto);
        return new ResponseEntity<>(createdFeature, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeatureDto> getFeatureById(@PathVariable Long id) {
        FeatureDto featureDto = featureService.getFeatureById(id);
        return new ResponseEntity<>(featureDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeatureDto> updateFeature(@PathVariable Long id, @RequestBody FeatureDto featureDto) {
        FeatureDto updatedFeature = featureService.updateFeature(id, featureDto);
        return new ResponseEntity<>(updatedFeature, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeature(@PathVariable Long id) {
        featureService.deleteFeature(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}