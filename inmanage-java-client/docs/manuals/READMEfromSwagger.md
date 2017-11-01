# javaclient

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>dk.sdu.less.inmanage</groupId>
    <artifactId>javaclient</artifactId>
    <version>1</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "dk.sdu.less.inmanage:javaclient:1"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/javaclient-1.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import gen.java.api.invoker.*;
import gen.java.api.invoker.auth.*;
import gen.java.api.model.*;
import AdminsApi;

import java.io.File;
import java.util.*;

public class AdminsApiExample {

    public static void main(String[] args) {
        
        AdminsApi apiInstance = new AdminsApi();
        User user = new User(); // User | User to add
        try {
            apiInstance.addUser(user);
        } catch (ApiException e) {
            System.err.println("Exception when calling AdminsApi#addUser");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://localhost:8080*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AdminsApi* | [**addUser**](../models/AdminsApi.md#addUser) | **POST** /Users | adds a user
*AdminsApi* | [**searchUser**](../models/AdminsApi.md#searchUser) | **GET** /Users | searches Users


## Documentation for Models

 - [User](../models/User.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



