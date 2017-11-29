package gen.java.api;

import gen.java.invoker.ApiException;
import gen.java.model.Project;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ProjectApi
 */
public class ProjectApiTest {

    private final ProjectApi api = new ProjectApi();

    
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
     * Deletes a given project
     *
     * Deletes a given project using the project ID
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteProjectTest() throws ApiException {
        String projectId = null;
        String passWord = null;
        // api.deleteProject(projectId, passWord);

        // TODO: test validations
    }
    
    /**
     * Edits a project
     *
     * Edits the values of a project
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void editProjectTest() throws ApiException {
        Project projectObject = null;
        // api.editProject(projectObject);

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
     * Gets information about a specific project
     *
     * Gets information about a specific project given a project ID
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getSpecificTaskTest() throws ApiException {
        String projectID = null;
        // Project response = api.getSpecificTask(projectID);

        // TODO: test validations
    }
    
    /**
     * Get the amount of user tagged on a project
     *
     * Get the amount of user tagged on a project based on projectID
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getUserAmountTest() throws ApiException {
        String projectId = null;
        // Integer response = api.getUserAmount(projectId);

        // TODO: test validations
    }
    
}
