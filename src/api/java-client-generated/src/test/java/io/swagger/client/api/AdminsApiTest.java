package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for AdminsApi
 */
public class AdminsApiTest {

    private final AdminsApi api = new AdminsApi();

    
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
        Integer skip = null;
        Integer limit = null;
        // List<User> response = api.searchUser(searchUsername, skip, limit);

        // TODO: test validations
    }
    
}
