package io.subspacedev.alm.service.impl;

import io.subspacedev.alm.dto.FeatureDto;
import io.subspacedev.alm.domain.model.Feature;
import io.subspacedev.alm.mapper.FeatureMapper;
import io.subspacedev.alm.domain.repository.FeatureRepository;
import io.subspacedev.alm.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    @Autowired
    private FeatureMapper featureMapper;

    @Override
    public FeatureDto createFeature(FeatureDto featureDto) {
        Feature feature = featureMapper.toEntity(featureDto);
        Feature savedFeature = featureRepository.save(feature);
        return featureMapper.toDto(savedFeature);
    }

    @Override
    public FeatureDto getFeatureById(Long id) {
        Feature feature = featureRepository.findById(id).orElseThrow(() -> new RuntimeException("Feature not found"));
        return featureMapper.toDto(feature);
    }

    @Override
    public FeatureDto updateFeature(Long id, FeatureDto featureDto) {
        Feature feature = featureRepository.findById(id).orElseThrow(() -> new RuntimeException("Feature not found"));
        feature.setName(featureDto.getName());
        feature.setDescription(featureDto.getDescription());
        Feature updatedFeature = featureRepository.save(feature);
        return featureMapper.toDto(updatedFeature);
    }

    @Override
    public void deleteFeature(Long id) {
        featureRepository.deleteById(id);
    }
}