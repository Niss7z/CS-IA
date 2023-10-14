package com.models;


import javafx.scene.Parent;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Folder {
    private int id;
    private String name;
    private ArrayList<Task> tasks;
    private Folder parent;
    public Folder(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Folder (int id, String name, ArrayList<Task> tasks, Folder parent){
        this.id = id;
        this.name = name;
        this.tasks = tasks;
        this.parent = parent;
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

    public Folder getParent(){
        return parent;
    }
    public void setParent(Folder parent){
        this.parent = parent;
    }

}
