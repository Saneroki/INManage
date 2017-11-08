package main.java.domain.task;

/*
* Currently being worked on by Mikkel.
*/

import main.java.domain.project.Project;

public class Task {

    private String dueTime;
    private String startTime;
    private String taskDescription;
    private String taskTitle;
    private String taskStatus;

    public Task(String projectID) { //project ID ties the task to a specific project.

        Project project = new Project("");  // Instance of the project class in order to use the projectID.
        Task task = new Task(project.getProjectID());   // Usage of projectID.
    }

    //Change Task Status
    public String changeTaskStatus(String status) {
        taskStatus = status;
        return taskStatus;
    }

    //Due time methods.
    public String getDueTime() {

        return dueTime;
    }

    public void setDueTime() {

        this.dueTime = dueTime;
    }

    //start time methods.
    public String getStartTime() {

        return startTime;
    }

    public void setStartTime() {

        this.startTime = startTime;
    }

    //Task Title methods
    public String getTaskTitle() {

        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {

        this.taskTitle = taskTitle;
    }

    //Task description.
    public String getTaskDescription() {

        return taskDescription;
    }

    public void setTaskDescription() {

        this.taskDescription = taskDescription;
    }
}