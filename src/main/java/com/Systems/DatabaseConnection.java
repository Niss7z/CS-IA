package com.Systems;
import com.models.Folder;
import com.models.Task;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {
    public Connection db;
    private static final String DATABASE_URL = "jdbc:sqlite:src/main/resource/database/tasks.db"; // connecting to database
    private Connection getConnection(){
        try {
            db = DriverManager.getConnection(DATABASE_URL);

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return db;
    }
    // Insert a task into the database
    public void insertTask(Task task) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            // Define the SQL query
            String sql = "INSERT INTO tasks(task_id,folder_id,name,status_id,parent_task_id,start_date,end_date,description) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Map the Task object properties to the database columns
            preparedStatement.setInt(1, task.getId());
            preparedStatement.setInt(2,task.getParent_folder().getId());
            preparedStatement.setString(3,task.getName());
            preparedStatement.setInt(4,task.getStatus().getId());
            preparedStatement.setInt(5,task.getParent().getId());
            preparedStatement.setString(6, task.getStart_date());
            preparedStatement.setString(7, task.getDue_date());
            preparedStatement.setString(8, task.getDescription());

            // Execute the SQL query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update a task in the database
    public void updateTask(Task task) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            // Define the SQL query
            String sql = "UPDATE tasks SET task_id=?, folder_id=?, name=?, status_id=?, parent_task_id=?, " +
                    "start_date=?, due_date=?, description=?, WHERE task_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Map the Task object properties to the database columns
            preparedStatement.setInt(1, task.getId());
            preparedStatement.setInt(2,task.getParent_folder().getId());
            preparedStatement.setString(3,task.getName());
            preparedStatement.setInt(4,task.getStatus().getId());
            preparedStatement.setInt(5,task.getParent().getId());
            preparedStatement.setString(6, task.getStart_date());
            preparedStatement.setString(7, task.getDue_date());
            preparedStatement.setString(8, task.getDescription());

            // Execute the SQL query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve all tasks from the database
    public ArrayList<Task> getAllTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String sql = "SELECT * FROM tasks";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Create a Task object and map the database columns to its properties
                int taskId = resultSet.getInt("task_id");
                int folderId = resultSet.getInt("folder_id");
                String name = resultSet.getString("name");
                int statusId = resultSet.getInt("status_id");
                int parentTaskId = resultSet.getInt("parent_task_id");
                String start_date = resultSet.getString("start_date");
                String due_date = resultSet.getString("due_date");
                String description = resultSet.getString("description");
                boolean isComplete = resultSet.getBoolean("is_complete");



            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }
    // Update an existing folder in the database
    public void updateFolder(Folder folder) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String sql = "UPDATE folders SET name=?, parent_id=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, folder.getName());
            preparedStatement.setInt(2, folder.getParent_id());
            preparedStatement.setInt(3, folder.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a folder from the database by its ID
    public void deleteFolder(int folderId) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String sql = "DELETE FROM folders WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, folderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve all folders from the database
    public ArrayList<Folder> getAllFolders() {
        ArrayList<Folder> folders = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String sql = "SELECT * FROM folders";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int folderId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int parentId = resultSet.getInt("parent_id");

                Folder folder = new Folder(folderId, name, null, parentId); // Modify this line accordingly
                folders.add(folder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return folders;
    }
}
