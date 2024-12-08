package org.example;

public class Task {
    private String desc;
    private int weight;

    public Task(int weight, String desc) {
        this.desc = desc;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
