package com.example.taskmanager.model;

public record Task(
        Long id,
        String title,
        String description,
        String status) {
}