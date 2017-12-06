package server.domain.project;

import server.domain.task.Task;
import server.domain.user.User;

import java.util.ArrayList;

public class Project {

    private ArrayList<Task> tasks = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    private String name;


    public Project(String name) {
        this.name = name;
    }
}
