package main.java.serverCom;

import gen.java.api.AdminsApi;
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

    public ServerComImpl(){
    }

    @Override
    public void addUser(String username, String password){

        //TODO: English please?
        //TODO: Why is this allways Null still?
        if (null == adminsApi) {
            System.out.println("APIEN ER NULL AF EN ELLER ANDEN GRUND!!");
        } else {
            System.out.println("_____APIEN ER ikke NULL");
        }

        User tempUser = new User();

        System.out.println("username: " + username);
        tempUser.setName(username);
        System.out.println("password: " + password);
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
            return userApi.loginUser(userName, password);
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


        //TODO: It says userID but we use Prohect ID, needs to be changed in next version of the API.

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

    @Override
    public void addUserToProject(String userID, String projecID) {

        //It says id but it is username
        try {
            userApi.addUserToProject(projecID,userID);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }


}
