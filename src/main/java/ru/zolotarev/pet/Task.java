package ru.zolotarev.pet;

import lombok.*;

import java.time.LocalDate;

@Data
public class Task {
    @NonNull private String taskName;
    private String description;
    private LocalDate deadline;
    private TaskStatus status;
}


