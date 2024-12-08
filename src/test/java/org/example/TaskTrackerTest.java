package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class TaskTrackerTest {
    private TaskTracker taskTracker;
    private ArrayList<Employee> employees;
    private ArrayList<Task> tasks;

    TaskTrackerTest(){
        this.taskTracker = new TaskTracker();
        this.employees = new ArrayList<>();
        this.tasks = new ArrayList<>();

        employees.add(new Employee("Ann"));
        employees.add(new Employee("Max"));

    }

    @Test
    public void test1(){
        tasks.add(new Task(1, "Learn java"));
        tasks.add(new Task(1, "Learn Spring"));
        tasks.add(new Task(1, "Learn SQL"));
        tasks.add(new Task(1, "Learn Docker"));
        tasks.add(new Task(1, "Learn OOP"));

        taskTracker.manageEqualTasks(tasks, employees);
        Assertions.assertEquals(employees.get(0).getTasksWeight(), 3);
        Assertions.assertEquals(employees.get(1).getTasksWeight(), 2);
    }

    @Test
    public void test2(){
        tasks.add(new Task(1, "Learn java"));
        tasks.add(new Task(1, "Learn Spring"));
        tasks.add(new Task(1, "Learn SQL"));
        tasks.add(new Task(1, "Learn Docker"));
        tasks.add(new Task(1, "Learn OOP"));
        tasks.add(new Task(1, "Learn Git"));

        employees.add(new Employee("Petya"));

        taskTracker.manageEqualTasks(tasks, employees);
        Assertions.assertEquals(employees.get(0).getTasksWeight(), 2);
        Assertions.assertEquals(employees.get(1).getTasksWeight(), 2);
        Assertions.assertEquals(employees.get(2).getTasksWeight(), 2);
    }

    @Test
    public void test3(){
        tasks.add(new Task(14, "Learn java"));
        tasks.add(new Task(5, "Learn Spring"));
        tasks.add(new Task(4, "Learn SQL"));
        tasks.add(new Task(2, "Learn Docker"));
        tasks.add(new Task(2, "Learn OOP"));


        employees.add(new Employee("Petya"));

        taskTracker.manageDifferentTasks(tasks, employees);

        Set<Integer> expectedWeights = new HashSet<>();
        Set<Integer> actualWeights = new HashSet<>();

        expectedWeights.add(14);
        expectedWeights.add(7);
        expectedWeights.add(6);

        for(Employee e : employees){
            actualWeights.add(e.getTasksWeight());
        }

        assertEquals(expectedWeights, actualWeights);

    }



}
