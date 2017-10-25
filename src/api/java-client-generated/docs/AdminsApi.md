# AdminsApi

All URIs are relative to *https://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addUser**](AdminsApi.md#addUser) | **POST** /Users | adds a user
[**searchUser**](AdminsApi.md#searchUser) | **GET** /Users | searches Users


<a name="addUser"></a>
# **addUser**
> addUser(user)

adds a user

Adds a User to the system

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AdminsApi;


AdminsApi apiInstance = new AdminsApi();
User user = new User(); // User | User to add
try {
    apiInstance.addUser(user);
} catch (ApiException e) {
    System.err.println("Exception when calling AdminsApi#addUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **user** | [**User**](User.md)| User to add | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="searchUser"></a>
# **searchUser**
> List&lt;User&gt; searchUser(searchUsername, skip, limit)

searches Users

By passing in the appropriate options, you can search for available User in the system 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AdminsApi;


AdminsApi apiInstance = new AdminsApi();
String searchUsername = "searchUsername_example"; // String | pass a search string for looking up User
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    List<User> result = apiInstance.searchUser(searchUsername, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AdminsApi#searchUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **searchUsername** | **String**| pass a search string for looking up User |
 **skip** | **Integer**| number of records to skip for pagination | [optional]
 **limit** | **Integer**| maximum number of records to return | [optional]

### Return type

[**List&lt;User&gt;**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

