package com.models;

import java.util.ArrayList;

public class Task {
    private int id;
    private Folder parent_folder;
    private int parent_id;
    private String name;
    private String start_date;
    private String due_date;
    private ArrayList<Tag> tags;
    private String description;
    // private recurrence (not sure)
    private Status isComplete;

    public Task(int id, Task parent, String name, String start_date, String due_date, ArrayList<Tag> tags, String description){
        this.id = id;
        this.parent = parent;
        this.name = name;
        this.start_date = start_date;
        this.due_date = due_date;
        this.tags = tags;
        this.description = description;
    }


    // getter setters
    public int getId(){return this.id;}
    public void setId(int id){this.id = id;}

    public Task getParentId(){return parent;}
    public void setParentId(int parentId){this.parentId = parent;}

    public String getName(){return name;}
    public void setName(String name){ this.name = name;}

    public String getStart_date(){return start_date;}
    public void setStart_date(String start_date){this.start_date=start_date;}

    public String getDue_date(){return due_date;}
    public void setDue_date(String due_date){this.due_date=due_date;}

    public ArrayList<Tag> getTags(){return tags;}
    public void setTags(ArrayList<Tag> tags){this.tags = tags;}

    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}

    public boolean getIsComplete(){return isComplete;}
    public void setIsComplete(boolean isComplete){this.isComplete = isComplete;}


    public Folder getParent_folder() {
        return parent_folder;
    }

    public void setParent_folder(Folder parent_folder) {
        this.parent_folder = parent_folder;
    }

    public int getStatus(){
        if(isComplete){
            return 1;
        } else {
            return 2;
        }
    }


}
