

package main.java.example;


import gen.java.invoker.*;
import gen.java.invoker.auth.*;
import gen.java.model.*;
import gen.java.AdminsApi;

import java.io.File;
import java.util.*;

public class AdminsApiExample {

    public static void main(String[] args) {

        AdminsApi apiInstance = new AdminsApi();

        try {
            addUser(apiInstance);
            searchUser(apiInstance);

        } catch (ApiException e) {
            System.err.println("Exception when calling AdminsApi#addUser");
            e.printStackTrace();
        }
    }


    private static void addUser(AdminsApi apiInstance) throws ApiException {
        User user = new User(); // User | User to add
        user.setUserId("666");
        user.setTaskName("Malte");
        apiInstance.addUser(user);
        System.out.println(user);
    }

    private static void searchUser(AdminsApi apiInstance) throws ApiException {
        System.out.println("");
        System.out.println("Start of interesting part");
        System.out.println(apiInstance.searchUser("Malte",0,100));
        //System.out.println(apiInstance.searchUser("Glenn",0,100));
    }
}

