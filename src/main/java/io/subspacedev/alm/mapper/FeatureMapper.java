package io.subspacedev.alm.mapper;

import io.subspacedev.alm.dto.FeatureDto;
import io.subspacedev.alm.domain.model.Feature;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeatureMapper {
    FeatureDto toDto(Feature feature);

    Feature toEntity(FeatureDto featureDto);
}