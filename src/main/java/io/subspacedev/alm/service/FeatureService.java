package io.subspacedev.alm.service;

import io.subspacedev.alm.dto.FeatureDto;

public interface FeatureService {
    FeatureDto createFeature(FeatureDto featureDto);

    FeatureDto getFeatureById(Long id);

    FeatureDto updateFeature(Long id, FeatureDto featureDto);

    void deleteFeature(Long id);
}