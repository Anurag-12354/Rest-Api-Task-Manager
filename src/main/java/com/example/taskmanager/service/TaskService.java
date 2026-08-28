package com.example.taskmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.taskmanager.model.Task;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();

    public List<Task> getAllTask() {
        return tasks;
    }

    public Task addTask(Task task) {
        tasks.add(task);
        return task;
    }

    public Task getTaskById(Long id) {
        for (Task task : tasks) {
            if (task.id().equals(id)) {
                return task;
            }
        }

        return null;
    }

    public boolean deleteById(Long id) {
        return tasks.removeIf(task -> task.id().equals(id));
    }

    public Task updateTask(Long id, Task updatedTask) {

        for (int i = 0; i < tasks.size(); i++) {

            Task task = tasks.get(i);

            if (task.id().equals(id)) {

                Task newTask = new Task(
                        id,
                        updatedTask.title(),
                        updatedTask.description(),
                        updatedTask.status());

                tasks.set(i, newTask);

                return newTask;
            }
        }

        return null;
    }
}