package org.example;

import java.util.*;

public class TaskTracker {

    public void manageEqualTasks(List<Task> tasks, List<Employee> employees) {
        int size = tasks.size();
        int taskCount = size / employees.size();
        int extraTaskCount = size % employees.size();
        Iterator<Task> taskIterator = tasks.iterator();

        for (Employee employee : employees) {
                for (int i = 0; i < taskCount; i++){
                    employee.addTask(taskIterator.next());
                }
                if (extraTaskCount > 0){
                    employee.addTask(taskIterator.next());
                    extraTaskCount--;
                }
        }
    }

    public void manageDifferentTasks(List<Task> tasks, List<Employee> employees){
        PriorityQueue<Employee> employeeQueue = new PriorityQueue<>(Comparator.comparingInt(Employee::getTasksWeight));

        employeeQueue.addAll(employees);

        tasks.sort(Comparator.comparingInt(Task::getWeight).reversed());

        for (Task task : tasks) {
            Employee leastLoadedEmployee = employeeQueue.poll();
            leastLoadedEmployee.addTask(task);
            employeeQueue.offer(leastLoadedEmployee);
        }
    }
}