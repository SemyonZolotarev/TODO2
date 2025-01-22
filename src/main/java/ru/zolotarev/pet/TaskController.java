package ru.zolotarev.pet;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class TaskController {

    @Getter
    private final TaskRepository tr = new TaskRepository();

    public void createTask(String name, String description, String deadline) {
        Task task = new Task();

        if (name != null) {
            task.setTaskName(name);
        } else {
            task.setTaskName("Default");
        }

        task.setDescription(description);

        deadlineExctracting(task, deadline);
    }

    public static void deadlineExctracting(Task task, @NotNull String deadline) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        if (deadline.isEmpty()) {
            System.out.println("Дата не может быть пустой");
        } else {
            try {
                LocalDate newDeadline = LocalDate.parse(deadline, dtf);
                if (newDeadline.compareTo(LocalDate.now()) > 0) {
                    task.setDeadline(newDeadline);
                } else {
                    System.out.println("Дата не может быть указана в прошедшем времени.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат даты. Ожидается dd-MM-yyyy. Устанавливается дедлайн на завтра");
                task.setDeadline(LocalDate.now().plusDays(1));
            }
        }
    }

    public void addTask(Task task) {
        tr.addTask(task);
    }

    public Task getTask(String name) {
        return tr.getTask(name);
    }

    public void deleteTask(String name) {
        Task task = tr.getTask(name);
        tr.removeTask(task);
        System.out.println("Задача '" + name + "' была удалена.");
    }

    public void deleteTask(int ID) {
        Task task = tr.getTask(ID);
        if (ID > 0) {
            tr.removeTask(task);
            System.out.println("Задача с ID #" + ID + " была удалена.");
        } else System.out.println("Такой задачи не существует.");
    }
}
