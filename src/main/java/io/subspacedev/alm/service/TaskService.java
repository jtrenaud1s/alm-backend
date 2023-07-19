package io.subspacedev.alm.service;

import io.subspacedev.alm.dto.TaskDto;

public interface TaskService {
    TaskDto createTask(TaskDto taskDto);

    TaskDto getTaskById(Long id);

    TaskDto updateTask(Long id, TaskDto taskDto);

    void deleteTask(Long id);
}