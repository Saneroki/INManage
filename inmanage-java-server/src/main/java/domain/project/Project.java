package main.java.domain.project;

import main.java.domain.task.Task;
import main.java.domain.user.User;

import java.util.ArrayList;

public class Project {

    private ArrayList<Task> tasks = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    private String name;


    public Project(String name) {
        this.name = name;
    }
}
