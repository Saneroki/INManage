package main.java.serverCom;

import gen.java.AdminsApi;
import gen.java.api.UserApi;
import gen.java.invoker.ApiException;
import gen.java.model.AddTaskObject;
import gen.java.model.Project;
import gen.java.model.Task;
import gen.java.model.User;

import java.util.List;

public class ServerComImpl implements ServerCom {

    private UserApi userApi = new UserApi();
    private AdminsApi adminsApi = new AdminsApi();


    @Override
    public void addUser(String username, String password) {
        User tempUser = new User();

        tempUser.setName(username);
        tempUser.setPassword(password);

        try {
            adminsApi.addUser(tempUser);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String loginUser(String userName, String password) {
        try {
            String uuid = userApi.loginUser(userName, password);
            return uuid;
        } catch (ApiException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void addProject(Project project) {
        try {
            userApi.addProject(project);
        } catch (ApiException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addTask(AddTaskObject task) {
        try {
            userApi.addTask(task);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Project> getAllProjects(String userID) {

        try {
            return userApi.getAllProjects(userID);
        } catch (ApiException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Task> getAllTasks(String projectID) {
        try {
            return userApi.getTask(projectID);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return null;
    }
}
