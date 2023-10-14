package com.Systems;

import com.models.Folder;
import com.models.Task;

import java.util.ArrayList;

public class TaskSystem {
    // this has to be the same throughout all classes
    private static ArrayList<Folder> all_folders;
    private static ArrayList<Task> all_tasks;
    DatabaseConnection db = new DatabaseConnection();
    public ArrayList<Folder> getAll_folders() {
        return db.getAllFolders();
    }

    public ArrayList<Task> getAll_tasks(){
        return db.getAllTasks();
    }

    // because tasks can be moved to other folders
    public void moveTask(Task task, Folder folder){
        task.getParent_folder().getTasks().remove(task); // before setting new Parent, task needs to be removed from the folder first
        task.setParent_folder(folder); // task needs to save parent folder first
        folder.getTasks().add(task); // folder needs to store the task
        db.updateTask(task); // it needs to be updated in the database
        db.updateFolder(folder);
    }

    public void nestFolders(Folder folder, Folder parentFolder){
        folder.setParent(parentFolder);
        db.updateFolder(folder); // it is only the child folder that needs to be updated
    }

    public void nestTask(Task task, Task Parent){
        task.setParent(Parent);
        db.updateTask(task);
    }

}
