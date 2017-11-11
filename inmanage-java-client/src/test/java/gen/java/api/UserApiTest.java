package test.java.gen.java.api;

import gen.java.api.UserApi;
import gen.java.invoker.ApiException;
import gen.java.model.AddTaskObject;
import gen.java.model.Project;
import gen.java.model.Task;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for UserApi
 */
public class UserApiTest {

    private final UserApi api = new UserApi();

    
    /**
     * Adds a project
     *
     * A user creates a new project
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addProjectTest() throws ApiException {
        Project project = null;
        // api.addProject(project);

        // TODO: test validations
    }
    
    /**
     * Adds a new task to a project
     *
     * Adds a new task to a project, whil adding the id&#39;s of the task and the user.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addTaskTest() throws ApiException {
        AddTaskObject addTaskObject = null;
        // api.addTask(addTaskObject);

        // TODO: test validations
    }
    
    /**
     * Adds a user to a project
     *
     * Adds a user to a specific project
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addUserToProjectTest() throws ApiException {
        String projectID = null;
        String theIDOfTheUserMakingTheOperation = null;
        // api.addUserToProject(projectID, theIDOfTheUserMakingTheOperation);

        // TODO: test validations
    }
    
    /**
     * Get&#39;s all projects for a user
     *
     * Get&#39;s all the projects a user participates in
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getAllProjectsTest() throws ApiException {
        String userId = null;
        // List<Project> response = api.getAllProjects(userId);

        // TODO: test validations
    }
    
    /**
     * Gets the tasks based on project id
     *
     * Retrevies a task based on the project the task is in with the project ID
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getTaskTest() throws ApiException {
        String projectID = null;
        // List<Task> response = api.getTask(projectID);

        // TODO: test validations
    }
    
    /**
     * Logs in the user
     *
     * Logs in the user with username and password, returns ID to access the content
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void loginUserTest() throws ApiException {
        String username = null;
        String password = null;
        // String response = api.loginUser(username, password);

        // TODO: test validations
    }
    
}
