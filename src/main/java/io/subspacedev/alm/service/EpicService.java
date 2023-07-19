package io.subspacedev.alm.service;

import io.subspacedev.alm.dto.EpicDto;

public interface EpicService {
    EpicDto createEpic(EpicDto epicDto);

    EpicDto getEpicById(Long id);

    EpicDto updateEpic(Long id, EpicDto epicDto);

    void deleteEpic(Long id);
}