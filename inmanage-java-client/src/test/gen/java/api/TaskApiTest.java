package gen.java.api;

import gen.java.invoker.ApiException;
import gen.java.model.Task;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for TaskApi
 */
public class TaskApiTest {

    private final TaskApi api = new TaskApi();

    
    /**
     * Deletes a given task
     *
     * Deletes a given task, if the given id matches
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteTaskTest() throws ApiException {
        String projectId = null;
        // api.deleteTask(projectId);

        // TODO: test validations
    }
    
    /**
     * Edit the values for a task
     *
     * Edits the values for a task given the task ID
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void editTaskTest() throws ApiException {
        Task taskObject = null;
        // api.editTask(taskObject);

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
     * get the amount of task for a project
     *
     * Get the amount of tasks for a project given a project ID
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getTaskAmountTest() throws ApiException {
        String projectId = null;
        // Integer response = api.getTaskAmount(projectId);

        // TODO: test validations
    }
    
}
