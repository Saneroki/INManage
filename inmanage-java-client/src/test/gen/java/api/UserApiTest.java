package gen.java.api;

import gen.java.invoker.ApiException;
import gen.java.model.AddTaskObject;
import gen.java.model.User;
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
     * adds a user
     *
     * Adds a User to the system
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addUserTest() throws ApiException {
        User user = null;
        // api.addUser(user);

        // TODO: test validations
    }
    
    /**
     * Deletes the chosen user
     *
     * Deletes the given user based on the userID
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteUserTest() throws ApiException {
        String userID = null;
        String password = null;
        // api.deleteUser(userID, password);

        // TODO: test validations
    }
    
    /**
     * Edit the user
     *
     * Edit the user, changing the information.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void editUserTest() throws ApiException {
        User userObject = null;
        // api.editUser(userObject);

        // TODO: test validations
    }
    
    /**
     * Get the details of a user
     *
     * Gets the details of a user based on the ID provided
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getUserTest() throws ApiException {
        String userId = null;
        // Object response = api.getUser(userId);

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
    
    /**
     * searches Users
     *
     * By passing in the appropriate options, you can search for available User in the system 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchUserTest() throws ApiException {
        String searchUsername = null;
        Integer limit = null;
        // List<User> response = api.searchUser(searchUsername, limit);

        // TODO: test validations
    }
    
}
