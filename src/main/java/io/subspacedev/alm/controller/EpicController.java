package io.subspacedev.alm.controller;

import io.subspacedev.alm.dto.EpicDto;
import io.subspacedev.alm.service.EpicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/epics")
public class EpicController {

    @Autowired
    private EpicService epicService;

    @PostMapping
    public ResponseEntity<EpicDto> createEpic(@RequestBody EpicDto epicDto) {
        EpicDto createdEpic = epicService.createEpic(epicDto);
        return new ResponseEntity<>(createdEpic, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EpicDto> getEpicById(@PathVariable Long id) {
        EpicDto epicDto = epicService.getEpicById(id);
        return new ResponseEntity<>(epicDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EpicDto> updateEpic(@PathVariable Long id, @RequestBody EpicDto epicDto) {
        EpicDto updatedEpic = epicService.updateEpic(id, epicDto);
        return new ResponseEntity<>(updatedEpic, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEpic(@PathVariable Long id) {
        epicService.deleteEpic(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}