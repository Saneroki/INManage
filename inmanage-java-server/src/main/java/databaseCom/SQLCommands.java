package main.java.databaseCom;

import java.sql.*;
import java.util.UUID;

/**
 * Created by omnhaww on 23/10/2017.
 */
public class SQLCommands implements ISQLCommands {

    private static SQLCommands instance = null;
    private SQLConnect sqlconnect;
    private Connection con;

    public SQLCommands() throws SQLException {
        sqlconnect = new SQLConnect();
        con = sqlconnect.connect();
    }

    public static SQLCommands getInstance() throws SQLException {
        if (instance == null) {
            instance = new SQLCommands();
        }
        return instance;
    }

    /**
     * pepak16
     * @param id
     * @param username
     * @param password
     * @param firstname
     * @param lastname
     * @param type
     * @return boolean
     * @throws SQLException
     *
     * Inserts the values from the argument into the table user in database
     * by executing an insert sql statement.
     */
    @Override
    public boolean registerUser(UUID id, String username, String password, String firstname, String lastname, String type) throws SQLException {
        Statement statement = con.createStatement();
        try {
            statement.execute("INSERT INTO public.user VALUES ('"+id+"','"+username+"','"+password+"','"+firstname+"','"+lastname+"','"+type+"');");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    /**
     * pepak16
     * @param username
     * @param password
     * @return boolean
     * @throws SQLException
     *
     * Checks whether the entered username and password matches in the database or
     * not and returns the truth values respectively.
     */
    @Override
    public boolean checkUserLogin(String username, String password) throws SQLException {
        Statement statement = con.createStatement();
        try {
            ResultSet resultset = statement.executeQuery("SELECT password FROM public.user WHERE username = '"+username+"';");
            resultset.next();
            if (resultset.getString(1).equals(password)) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    /**
     * pepak16
     * @param username
     * @return String
     * @throws SQLException
     *
     * Gets password from the database via the username.
     */
    @Override
    public String getPassword(String username) throws SQLException {
        Statement statement = con.createStatement();
        try {
            ResultSet resultset = statement.executeQuery("SELECT password FROM public.user WHERE username = '"+username+"';");
            resultset.next();
            return resultset.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Caused by: nothing was fetched from database, could perhaps be username is wrong or doesn't exist.");
            return null;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    /**
     * pepak16
     * @param username
     * @return String
     * @throws SQLException
     *
     * Gets firstname from the database via the username.
     */
    @Override
    public String getFirstname(String username) throws SQLException {
        Statement statement = con.createStatement();
        try {
            ResultSet resultset = statement.executeQuery("SELECT firstname FROM public.user WHERE username = '"+username+"';");
            resultset.next();
            return resultset.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Caused by: nothing was fetched from database, could perhaps be username is wrong or doesn't exist.");
            return null;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    @Override
    public String getLastname(String username) throws SQLException {
        Statement statement = con.createStatement();
        try {
            ResultSet resultset = statement.executeQuery("SELECT lastname FROM public.user WHERE username = '"+username+"';");
            resultset.next();
            return resultset.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Caused by: nothing was fetched from database, could perhaps be username is wrong or doesn't exist.");
            return null;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    /**
     * pepak16
     * @param username
     * @return boolean
     * @throws SQLException
     *
     * Use the argument for passing one or more information about the user
     */
    @Override
    public boolean setUsername(String username) throws SQLException {
        Statement statement = con.createStatement();
        try {
            statement.executeQuery("UPDATE public.user SET username = '"+username+"' WHERE username = '"+username+"';");
            return true;
        } catch (SQLException e) {
            System.out.println("\nCaused by: username doesn't exist in the database.");
            return false;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    /**
     * pepak16
     * @param username
     * @return boolean
     * @throws SQLException
     *
     * Use the argument for passing one or more information about the user
     */
    @Override
    public boolean setPassword(String username, String password) throws SQLException {
        Statement statement = con.createStatement();
        try {
            statement.executeQuery("UPDATE public.user SET password = '"+password+"' WHERE username = '"+username+"';");
            return true;
        } catch (SQLException e) {
            System.out.println("\nCaused by: username doesn't exist in the database perhaps.");
            return false;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    /**
     * pepak16
     * @param username
     * @return boolean
     * @throws SQLException
     *
     * Use the argument for passing one or more information about the user
     */
    @Override
    public boolean setFirstname(String username, String firstname) throws SQLException {
        Statement statement = con.createStatement();
        try {
            statement.executeQuery("UPDATE public.user SET firstname = '"+firstname+"' WHERE username = '"+username+"';");
            return true;
        } catch (SQLException e) {
            System.out.println("\nCaused by: username doesn't exist in the database.");
            return false;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    /**
     * pepak16
     * @param username
     * @return boolean
     * @throws SQLException
     *
     * Use the argument for passing one or more information about the user
     */
    @Override
    public boolean setLastname(String username,String lastname) throws SQLException {
        Statement statement = con.createStatement();
        try {
            statement.executeQuery("UPDATE public.user SET lastname = '"+lastname+"' WHERE username = '"+username+"';");
            return true;
        } catch (SQLException e) {
            System.out.println("\nCaused by: username doesn't exist in the database perhaps.");
            return false;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    /**
     * pepak16
     * @param username
     * @param type
     * @return boolean
     * @throws SQLException
     *
     * Changes the user type using the username and its corresponding type via the argument
     */
    @Override
    public boolean setUserType(String username,String type) throws SQLException {
        Statement statement = con.createStatement();
        try {
            return statement.execute("UPDATE public.user SET type = '"+type+"' WHERE username = '"+username+"';");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    /**
     * pepak16
     *
     * @param username
     * @return boolean
     * @throws SQLException
     *
     * Checking if there exists any user with the provided username via the argument.
     * If there is already an existing user in database the operation will return true,
     * else it will return true.
     *
     */
    @Override
    public boolean isUserExisting(String username) throws SQLException {
        Statement statement = con.createStatement();
        try {
            ResultSet resultset = statement.executeQuery("SELECT username FROM public.user WHERE username = '"+username+"';");
            resultset.next();
            if (resultset.getString(1).equals(username)) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("\nCaused by: username didn't exist and therefore nothing was returned in the resultset.");
            return false;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    /**
     * pepak16
     * @param username
     * @return boolean
     * @throws SQLException
     *
     * Checks whether the user is admin or not and return a truth value respectively.
     */
    @Override
    public boolean isUserAdmin(String username) throws SQLException {
        Statement statement = con.createStatement();
        try {
            ResultSet resultset = statement.executeQuery("SELECT type FROM public.user WHERE username = '"+username+"';");
            resultset.next();
            if (resultset.getString(1).equals("admin")) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("\nCaused by: the entered username doesn't exist in the database.");
            return false;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    @Override
    public String loginUser(String checkUsername, String checkPassword) throws SQLException {
        Statement statement = con.createStatement();

        try {
            ResultSet resultSet = statement.executeQuery("SELECT id FROM public.user WHERE username = '" + checkUsername + "' AND password = '" + checkPassword + "';");
            resultSet.next();
            return resultSet.getString(1);

            }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
