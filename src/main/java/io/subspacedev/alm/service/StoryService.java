package io.subspacedev.alm.service;

import io.subspacedev.alm.dto.StoryDto;

public interface StoryService {
    StoryDto createStory(StoryDto storyDto);

    StoryDto getStoryById(Long id);

    StoryDto updateStory(Long id, StoryDto storyDto);

    void deleteStory(Long id);
}