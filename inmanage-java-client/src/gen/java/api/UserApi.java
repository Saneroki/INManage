

package gen.java.api;

import gen.java.invoker.ApiCallback;
import gen.java.invoker.ApiClient;
import gen.java.invoker.ApiException;
import gen.java.invoker.ApiResponse;
import gen.java.invoker.Configuration;
import gen.java.invoker.Pair;
import gen.java.invoker.ProgressRequestBody;
import gen.java.invoker.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import gen.java.model.AddTaskObject;
import gen.java.model.User;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserApi {
    private ApiClient apiClient;

    public UserApi() {
        this(Configuration.getDefaultApiClient());
    }

    public UserApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for addTask
     * @param addTaskObject Adds a task to a project (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call addTaskCall(AddTaskObject addTaskObject, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = addTaskObject;

        // create path and map variables
        String localVarPath = "/task";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call addTaskValidateBeforeCall(AddTaskObject addTaskObject, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = addTaskCall(addTaskObject, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Adds a new task to a project
     * Adds a new task to a project, whil adding the id&#39;s of the task and the user.
     * @param addTaskObject Adds a task to a project (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void addTask(AddTaskObject addTaskObject) throws ApiException {
        addTaskWithHttpInfo(addTaskObject);
    }

    /**
     * Adds a new task to a project
     * Adds a new task to a project, whil adding the id&#39;s of the task and the user.
     * @param addTaskObject Adds a task to a project (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> addTaskWithHttpInfo(AddTaskObject addTaskObject) throws ApiException {
        com.squareup.okhttp.Call call = addTaskValidateBeforeCall(addTaskObject, null, null);
        return apiClient.execute(call);
    }

    /**
     * Adds a new task to a project (asynchronously)
     * Adds a new task to a project, whil adding the id&#39;s of the task and the user.
     * @param addTaskObject Adds a task to a project (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call addTaskAsync(AddTaskObject addTaskObject, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = addTaskValidateBeforeCall(addTaskObject, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for addUser
     * @param user User to add (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call addUserCall(User user, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = user;

        // create path and map variables
        String localVarPath = "/users";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call addUserValidateBeforeCall(User user, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = addUserCall(user, progressListener, progressRequestListener);
        return call;

    }

    /**
     * adds a user
     * Adds a User to the system
     * @param user User to add (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void addUser(User user) throws ApiException {
        addUserWithHttpInfo(user);
    }

    /**
     * adds a user
     * Adds a User to the system
     * @param user User to add (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> addUserWithHttpInfo(User user) throws ApiException {
        com.squareup.okhttp.Call call = addUserValidateBeforeCall(user, null, null);
        return apiClient.execute(call);
    }

    /**
     * adds a user (asynchronously)
     * Adds a User to the system
     * @param user User to add (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call addUserAsync(User user, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = addUserValidateBeforeCall(user, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for deleteUser
     * @param userID The ID of the user to delete (required)
     * @param password The password of the user (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteUserCall(String userID, String password, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/users";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (userID != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("userID", userID));
        if (password != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("password", password));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteUserValidateBeforeCall(String userID, String password, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling deleteUser(Async)");
        }
        
        // verify the required parameter 'password' is set
        if (password == null) {
            throw new ApiException("Missing the required parameter 'password' when calling deleteUser(Async)");
        }
        

        com.squareup.okhttp.Call call = deleteUserCall(userID, password, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Deletes the chosen user
     * Deletes the given user based on the userID
     * @param userID The ID of the user to delete (required)
     * @param password The password of the user (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteUser(String userID, String password) throws ApiException {
        deleteUserWithHttpInfo(userID, password);
    }

    /**
     * Deletes the chosen user
     * Deletes the given user based on the userID
     * @param userID The ID of the user to delete (required)
     * @param password The password of the user (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteUserWithHttpInfo(String userID, String password) throws ApiException {
        com.squareup.okhttp.Call call = deleteUserValidateBeforeCall(userID, password, null, null);
        return apiClient.execute(call);
    }

    /**
     * Deletes the chosen user (asynchronously)
     * Deletes the given user based on the userID
     * @param userID The ID of the user to delete (required)
     * @param password The password of the user (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteUserAsync(String userID, String password, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteUserValidateBeforeCall(userID, password, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for editUser
     * @param userObject The user object (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call editUserCall(User userObject, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = userObject;

        // create path and map variables
        String localVarPath = "/users";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call editUserValidateBeforeCall(User userObject, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = editUserCall(userObject, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Edit the user
     * Edit the user, changing the information.
     * @param userObject The user object (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void editUser(User userObject) throws ApiException {
        editUserWithHttpInfo(userObject);
    }

    /**
     * Edit the user
     * Edit the user, changing the information.
     * @param userObject The user object (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> editUserWithHttpInfo(User userObject) throws ApiException {
        com.squareup.okhttp.Call call = editUserValidateBeforeCall(userObject, null, null);
        return apiClient.execute(call);
    }

    /**
     * Edit the user (asynchronously)
     * Edit the user, changing the information.
     * @param userObject The user object (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call editUserAsync(User userObject, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = editUserValidateBeforeCall(userObject, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for getUser
     * @param userId The id of the user you want (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getUserCall(String userId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/users/details";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (userId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("userId", userId));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getUserValidateBeforeCall(String userId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new ApiException("Missing the required parameter 'userId' when calling getUser(Async)");
        }
        

        com.squareup.okhttp.Call call = getUserCall(userId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get the details of a user
     * Gets the details of a user based on the ID provided
     * @param userId The id of the user you want (required)
     * @return User
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public User getUser(String userId) throws ApiException {
        ApiResponse<User> resp = getUserWithHttpInfo(userId);
        return resp.getData();
    }

    /**
     * Get the details of a user
     * Gets the details of a user based on the ID provided
     * @param userId The id of the user you want (required)
     * @return ApiResponse&lt;User&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<User> getUserWithHttpInfo(String userId) throws ApiException {
        com.squareup.okhttp.Call call = getUserValidateBeforeCall(userId, null, null);
        Type localVarReturnType = new TypeToken<User>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get the details of a user (asynchronously)
     * Gets the details of a user based on the ID provided
     * @param userId The id of the user you want (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getUserAsync(String userId, final ApiCallback<User> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getUserValidateBeforeCall(userId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<User>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for loginUser
     * @param username The username of user logging in (required)
     * @param password The password of the user logging in (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call loginUserCall(String username, String password, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/users/login";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (username != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("username", username));
        if (password != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("password", password));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call loginUserValidateBeforeCall(String username, String password, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'username' is set
        if (username == null) {
            throw new ApiException("Missing the required parameter 'username' when calling loginUser(Async)");
        }
        
        // verify the required parameter 'password' is set
        if (password == null) {
            throw new ApiException("Missing the required parameter 'password' when calling loginUser(Async)");
        }
        

        com.squareup.okhttp.Call call = loginUserCall(username, password, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Logs in the user
     * Logs in the user with username and password, returns ID to access the content
     * @param username The username of user logging in (required)
     * @param password The password of the user logging in (required)
     * @return String
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public String loginUser(String username, String password) throws ApiException {
        ApiResponse<String> resp = loginUserWithHttpInfo(username, password);
        return resp.getData();
    }

    /**
     * Logs in the user
     * Logs in the user with username and password, returns ID to access the content
     * @param username The username of user logging in (required)
     * @param password The password of the user logging in (required)
     * @return ApiResponse&lt;String&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<String> loginUserWithHttpInfo(String username, String password) throws ApiException {
        com.squareup.okhttp.Call call = loginUserValidateBeforeCall(username, password, null, null);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Logs in the user (asynchronously)
     * Logs in the user with username and password, returns ID to access the content
     * @param username The username of user logging in (required)
     * @param password The password of the user logging in (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call loginUserAsync(String username, String password, final ApiCallback<String> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = loginUserValidateBeforeCall(username, password, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for searchUser
     * @param searchUsername pass a search string for looking up User (required)
     * @param limit maximum number of records to return (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call searchUserCall(String searchUsername, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/users";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (searchUsername != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("searchUsername", searchUsername));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call searchUserValidateBeforeCall(String searchUsername, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'searchUsername' is set
        if (searchUsername == null) {
            throw new ApiException("Missing the required parameter 'searchUsername' when calling searchUser(Async)");
        }
        

        com.squareup.okhttp.Call call = searchUserCall(searchUsername, limit, progressListener, progressRequestListener);
        return call;

    }

    /**
     * searches Users
     * By passing in the appropriate options, you can search for available User in the system 
     * @param searchUsername pass a search string for looking up User (required)
     * @param limit maximum number of records to return (optional)
     * @return List&lt;User&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<User> searchUser(String searchUsername, Integer limit) throws ApiException {
        ApiResponse<List<User>> resp = searchUserWithHttpInfo(searchUsername, limit);
        return resp.getData();
    }

    /**
     * searches Users
     * By passing in the appropriate options, you can search for available User in the system 
     * @param searchUsername pass a search string for looking up User (required)
     * @param limit maximum number of records to return (optional)
     * @return ApiResponse&lt;List&lt;User&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<User>> searchUserWithHttpInfo(String searchUsername, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = searchUserValidateBeforeCall(searchUsername, limit, null, null);
        Type localVarReturnType = new TypeToken<List<User>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * searches Users (asynchronously)
     * By passing in the appropriate options, you can search for available User in the system 
     * @param searchUsername pass a search string for looking up User (required)
     * @param limit maximum number of records to return (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call searchUserAsync(String searchUsername, Integer limit, final ApiCallback<List<User>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = searchUserValidateBeforeCall(searchUsername, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<User>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
