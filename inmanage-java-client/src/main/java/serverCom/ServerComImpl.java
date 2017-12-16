package main.java.serverCom;

import gen.java.api.ChatApi;
import gen.java.api.ProjectApi;
import gen.java.api.TaskApi;
import gen.java.api.UserApi;
import gen.java.invoker.ApiException;
import gen.java.model.AddTaskObject;
import gen.java.model.Project;
import gen.java.model.Task;
import gen.java.model.User;

import java.util.List;
import java.util.UUID;

public class ServerComImpl implements ServerCom {

    private final UserApi userApi = new UserApi();
    private final ProjectApi projectApi = new ProjectApi();
    private final TaskApi taskApi = new TaskApi();
    private final ChatApi chatApi = new ChatApi();

    public ServerComImpl(){
    }


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
            return userApi.loginUser(userName, password);
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


        //TODO: It says userID but we use Prohect ID, needs to be changed in next version of the API.

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
            return taskApi.getTask(UUID.fromString(projectID));
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

    @Override
    public void deleteUsers(String userID, String password) {
        try {
            userApi.deleteUser(userID, password);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editUser(User user) {
        try {
            userApi.editUser(user);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> searchUser(String name, Integer limit) {
        try {
            return userApi.searchUser(name,limit);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getSpecificUser(String userID) {
        try {
            return (User)userApi.getUser(userID);
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void deleteProject(String projectID, String password) {
        try {
            projectApi.deleteProject(projectID,password);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editProject(Project proj) {
        try {
            projectApi.editProject(proj);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Project getSpecificProject(String projID) {
        try {
            return projectApi.getSpecificProject(projID);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer getUserAmount(String projID) {
        try {
            return projectApi.getUserAmount(projID) ;
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteTask(String taskID) {
        try {
            taskApi.deleteTask(UUID.fromString(taskID));
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editTask(Task task) {
        try {
            taskApi.editTask(task);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer getTaskAmount(String taskID) {
        try {
            return taskApi.getTaskAmount(UUID.fromString(taskID));
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return null;
    }


}
