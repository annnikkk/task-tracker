package org.example;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private  String name;
    private List<Task> tasks;
    private int tasksWeight;

    public Employee(String name){
        this.name = name;
        this.tasks = new ArrayList<>();
        this.tasksWeight = 0;
    }

    public void addTask(Task newTask){
        tasks.add(newTask);
        tasksWeight += newTask.getWeight();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTasksWeight() {
        return tasksWeight;
    }
}
