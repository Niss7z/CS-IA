package com.Systems;

import com.models.Folder;
import com.models.Task;

import java.util.ArrayList;

public class TaskSystem {
    // this has to be the same throughout all classes
    private static ArrayList<Folder> all_folders;
    private static ArrayList<Task> all_tasks;

    public ArrayList<Folder> getAll_folders() {
        return all_folders;
    }

    public ArrayList<Task> getAll_tasks(){
        return all_tasks;
    }

    // because tasks can be moved to other folders
    public void moveTask(Task task, Folder folder){
        task.setParent_folder(folder);
        folder.getTasks().add(task);
        DatabaseConnection db = new DatabaseConnection();
        db.updateTask(task);
        db.updateFolder(folder);
    }



}
