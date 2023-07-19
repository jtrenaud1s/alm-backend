package io.subspacedev.alm.service.impl;

import io.subspacedev.alm.dto.StoryDto;
import io.subspacedev.alm.domain.model.Story;
import io.subspacedev.alm.mapper.StoryMapper;
import io.subspacedev.alm.domain.repository.StoryRepository;
import io.subspacedev.alm.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoryServiceImpl implements StoryService {

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private StoryMapper storyMapper;

    @Override
    public StoryDto createStory(StoryDto storyDto) {
        Story story = storyMapper.toEntity(storyDto);
        Story savedStory = storyRepository.save(story);
        return storyMapper.toDto(savedStory);
    }

    @Override
    public StoryDto getStoryById(Long id) {
        Story story = storyRepository.findById(id).orElseThrow(() -> new RuntimeException("Story not found"));
        return storyMapper.toDto(story);
    }

    @Override
    public StoryDto updateStory(Long id, StoryDto storyDto) {
        Story story = storyRepository.findById(id).orElseThrow(() -> new RuntimeException("Story not found"));
        story.setName(storyDto.getName());
        story.setDescription(storyDto.getDescription());
        Story updatedStory = storyRepository.save(story);
        return storyMapper.toDto(updatedStory);
    }

    @Override
    public void deleteStory(Long id) {
        storyRepository.deleteById(id);
    }
}