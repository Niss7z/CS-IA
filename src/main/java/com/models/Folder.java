package com.models;


import java.util.ArrayList;

public class Folder {
    private int id;
    private String name;
    private ArrayList<Task> tasks;
    private int parent_id;
    public Folder(int id, String name, ArrayList<Task> tasks, int parent_id){
        this.id = id;
        this.name = name;
        this.tasks = tasks;
        this.parent_id = parent_id;
    }

    public int getId(){return id;}
    public void setId(int id){
        this.id = id;
    }

    public String getName(){return name;}
    public void setName(String name){
        this.name = name;
    }

    public ArrayList<Task> getTasks(){return tasks;}
    public void setTasks(ArrayList<Task> tasks){
        this.tasks=tasks;
    }

    public int getParent_id(){
        return parent_id;
    }
    public void setParent_id(int parent_id){
        this.parent_id=parent_id;
    }

}
