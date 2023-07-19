package io.subspacedev.alm.controller;

import io.subspacedev.alm.dto.StoryDto;
import io.subspacedev.alm.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stories")
public class StoryController {

    @Autowired
    private StoryService storyService;

    @PostMapping
    public ResponseEntity<StoryDto> createStory(@RequestBody StoryDto storyDto) {
        StoryDto createdStory = storyService.createStory(storyDto);
        return new ResponseEntity<>(createdStory, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoryDto> getStoryById(@PathVariable Long id) {
        StoryDto storyDto = storyService.getStoryById(id);
        return new ResponseEntity<>(storyDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StoryDto> updateStory(@PathVariable Long id, @RequestBody StoryDto storyDto) {
        StoryDto updatedStory = storyService.updateStory(id, storyDto);
        return new ResponseEntity<>(updatedStory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStory(@PathVariable Long id) {
        storyService.deleteStory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}