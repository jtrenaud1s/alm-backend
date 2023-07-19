package io.subspacedev.alm.service.impl;

import io.subspacedev.alm.dto.TaskDto;
import io.subspacedev.alm.domain.model.Task;
import io.subspacedev.alm.mapper.TaskMapper;
import io.subspacedev.alm.domain.repository.TaskRepository;
import io.subspacedev.alm.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toDto(savedTask);
    }

    @Override
    public TaskDto getTaskById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        return taskMapper.toDto(task);
    }

    @Override
    public TaskDto updateTask(Long id, TaskDto taskDto) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setEstimatedHours(taskDto.getEstimatedHours());
        task.setToDoHours(taskDto.getToDoHours());
        task.setActualHours(taskDto.getActualHours());
        Task updatedTask = taskRepository.save(task);
        return taskMapper.toDto(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}