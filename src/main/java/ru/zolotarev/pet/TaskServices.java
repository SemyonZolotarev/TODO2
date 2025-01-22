package ru.zolotarev.pet;

import org.jetbrains.annotations.NotNull;

import static ru.zolotarev.pet.TaskController.deadlineExctracting;

public class TaskServices {
    TaskController tc = new TaskController();

    public void changeTask(String name, String decription, String deadline, String status) {
        Task task = tc.getTask(name);
        if (task != null) {
            task.setDescription(decription);
            changeTaskStatus(task.getTaskName(), status);
            deadlineExctracting(task, deadline);
        }
        System.out.println("Задачи с таким именем не существует.");
    }

    public void changeTaskStatus(String name, @NotNull String status) {
        TaskStatus taskStatus = null;
        try {
            taskStatus = TaskStatus.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Статус введён неверно.");
            return;
        }
        Task task = tc.getTask(name);
        task.setStatus(taskStatus);
    }

    public void changeTaskName(@NotNull String name, String newName) {
        if (!name.isEmpty()) {
            Task task = tc.getTask(name);
            task.setTaskName(newName);
        } else System.out.println("Введено неверное имя задачи.");
    }

    public void changeTaskDescription(@NotNull String name, String newDescription) {
        if (!name.isEmpty()) {
            Task task = tc.getTask(name);
            task.setDescription(newDescription);
        } else System.out.println("Введено неверное имя задачи.");
    }

    public void changeTaskDeadline(@NotNull String name, String newDeadline) {
        if (!name.isEmpty() && !newDeadline.isEmpty()) {
            Task task = tc.getTask(name);
            TaskController.deadlineExctracting(task, newDeadline);
        } else System.out.println("Введено неверное имя задачи.");
    }

    public void showAllTasks() {
        for (Task task : tc.getTr().getTasks()) {
            System.out.println(task.toString());
        }
    }
}
