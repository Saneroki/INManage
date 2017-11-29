package main.java.serverCom;

import gen.java.api.ProjectApi;
import gen.java.api.TaskApi;
import gen.java.api.UserApi;
import gen.java.invoker.ApiException;
import gen.java.model.AddTaskObject;
import gen.java.model.Project;
import gen.java.model.Task;
import gen.java.model.User;

import java.util.List;

public class ServerComImpl implements ServerCom {

    private final UserApi userApi = new UserApi();
    private final ProjectApi projectApi = new ProjectApi();
    private final TaskApi taskApi = new TaskApi();



    @Override
    public void addUser(String username, String password){

        User tempUser = new User();

        System.out.println("username: " + username);
        tempUser.setName(username);
        System.out.println("password: " + password);
        tempUser.setPassword(password);


        try {
            userApi.addUser(tempUser);
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
            projectApi.addProject(project);
        } catch (ApiException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addTask(AddTaskObject task) {

        //We should change this to be under the project API because we add the task to a project
        try {
            userApi.addTask(task);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Project> getAllProjects(String userID) {

        /*
        It says userID but we use Prohect ID, needs to be changed in next version of the API.
         */

        try {
            return projectApi.getAllProjects(userID);
        } catch (ApiException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Task> getAllTasks(String projectID) {
        try {
            return taskApi.getTask(projectID);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addUserToProject(String userID, String projecID) {

        //It says id but it is username
        try {
            projectApi.addUserToProject(projecID,userID);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }


}
