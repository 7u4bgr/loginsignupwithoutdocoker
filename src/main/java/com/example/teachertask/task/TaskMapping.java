package com.example.teachertask.task;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapping {
    TaskDTO taskToTaskDTO(Task task);
    Task taskDTOToTask(TaskDTO taskDTO);
}
