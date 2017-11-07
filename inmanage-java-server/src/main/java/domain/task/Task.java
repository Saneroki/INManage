package main.java.domain.task;

//import main.java.domain.project.Project;

public class Task {

    private String dueTime;
    private String startTime;
    private String taskDescription;
    private String taskTitle;
    private String taskStatus;

    public Task() { //project ID ties the task to a specific project.

        Task task = new Task();
    }

    //Change Task Status
    public String ChangeTaskStatus (String status) {
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
