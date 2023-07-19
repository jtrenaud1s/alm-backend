package io.subspacedev.alm.service.impl;

import io.subspacedev.alm.dto.EpicDto;
import io.subspacedev.alm.domain.model.Epic;
import io.subspacedev.alm.mapper.EpicMapper;
import io.subspacedev.alm.domain.repository.EpicRepository;
import io.subspacedev.alm.service.EpicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EpicServiceImpl implements EpicService {

    @Autowired
    private EpicRepository epicRepository;

    @Autowired
    private EpicMapper epicMapper;

    @Override
    public EpicDto createEpic(EpicDto epicDto) {
        Epic epic = epicMapper.toEntity(epicDto);
        Epic savedEpic = epicRepository.save(epic);
        return epicMapper.toDto(savedEpic);
    }

    @Override
    public EpicDto getEpicById(Long id) {
        Epic epic = epicRepository.findById(id).orElseThrow(() -> new RuntimeException("Epic not found"));
        return epicMapper.toDto(epic);
    }

    @Override
    public EpicDto updateEpic(Long id, EpicDto epicDto) {
        Epic epic = epicRepository.findById(id).orElseThrow(() -> new RuntimeException("Epic not found"));
        epic.setName(epicDto.getName());
        epic.setDescription(epicDto.getDescription());
        Epic updatedEpic = epicRepository.save(epic);
        return epicMapper.toDto(updatedEpic);
    }

    @Override
    public void deleteEpic(Long id) {
        epicRepository.deleteById(id);
    }
}