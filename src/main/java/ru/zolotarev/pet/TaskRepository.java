package ru.zolotarev.pet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class TaskRepository {
    private final List<Task> tasks = new ArrayList<>();

    public @Nullable Task getTask(String name) {
        return tasks.stream()
                .filter(t -> t.getTaskName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
    public @Nullable Task getTask(int ID) {
        return tasks.stream()
                .filter(t -> t.getID() == ID)
                .findFirst()
                .orElse(null);
    }


    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

}
