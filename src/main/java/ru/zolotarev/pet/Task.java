package ru.zolotarev.pet;

import lombok.*;

import java.time.LocalDate;

@Data
public class Task {
    private static int count = 0;
    private final int ID = ++count;
    private String taskName;
    private String description;
    private LocalDate deadline;
    private TaskStatus status = TaskStatus.TODO;
}


