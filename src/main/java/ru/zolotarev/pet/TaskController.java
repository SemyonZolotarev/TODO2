package ru.zolotarev.pet;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskController {
    @Getter
    private static final List<Task> TASKS = new ArrayList<>();

    public void addTask(Task task) {
        TASKS.add(task);
    }

    private static @Nullable Task getTask(String name) {
        Task task = TASKS.stream()
                .filter(t -> t.getTaskName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
        return task;
    }

    public boolean deleteTask(String name) {
        Task task = getTask(name);
        return TASKS.remove(task);
    }

    public boolean changeTaskStatus(String name, String status) {
        //Создается переменная "статус задачи" с null-значением
        TaskStatus taskStatus = null;
        //Проверяется на IllegalArgumentException. Если ошибка - выход из метода
        try {
            taskStatus = TaskStatus.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Статус введён неверно.");
            return false;
        }
        //Если проверка пройдена, то вызывается поток и поиск задачи по имени
        Task task = getTask(name);
        //Получили задачу. Если не null - устанавливаем статус.
        //Если задача не сущ-ет - выводит сообщение.
        if (task != null) {
            task.setStatus(taskStatus);
            return true;
        } else {
            System.out.println("Такой задачи не существует.");
            return false;
                }
    }

    public boolean changeTaskName(String name, String newName) {
        Task task = getTask(name);
        if (task != null && newName != null) {
            task.setTaskName(newName);
            return true;
        } else return false;

    }

    public boolean changeTaskDescription (String name, String newDescription){
        Task task = getTask(name);
        if (task != null && newDescription != null) {
            task.setDescription(newDescription);
            return true;
        } else return false;
    }

    public boolean changeTaskDeadline (String name, LocalDate newDeadline){
        Task task = getTask(name);
        if (task != null && newDeadline != null) {
            task.setDeadline(newDeadline);
            return true;
        } else return false;
    }

    public void showAllTasks(){
        for(Task task : TASKS){
            System.out.println(task.toString());
        }
    }

}
