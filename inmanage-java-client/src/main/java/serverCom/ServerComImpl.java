package main.java.serverCom;

import gen.java.AdminsApi;
import gen.java.api.UserApi;
import gen.java.invoker.ApiException;
import gen.java.model.User;

public class ServerComImpl implements ServerCom {

    private UserApi userApi = new UserApi();
    private AdminsApi adminsApi = new AdminsApi();


    @Override
    public void addUser(String username, String password) {
        User tempUser = new User();

        tempUser.setName(username);
        tempUser.setPassword(password);

        try {
            adminsApi.addUser(tempUser);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String loginUser(String userName, String password) {
        return null;
    }
}
