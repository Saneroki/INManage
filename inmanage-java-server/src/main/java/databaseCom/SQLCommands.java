package main.java.databaseCom;

import java.awt.*;
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
    public boolean addUser(String username, String password, String firstname, String lastname, String type) throws SQLException {
        Statement statement = con.createStatement();
        try {
            statement.execute("INSERT INTO public.user VALUES ('"+UUID.randomUUID()+"','"+username+"','"+password+"','"+firstname+"','"+lastname+"','"+type+"');");
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

    /**
     * Made by pepak16.
     * Gets lastname from the database via the username.
     * @param username
     * @return String
     * @throws SQLException
     */
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
     * Made by pepak16.
     * Changes the username for the user via his username.
     * @param username
     * @return boolean
     * @throws SQLException
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
     * Made by pepak16.
     * Changes the users password via his username and password.
     * @param username
     * @return boolean
     * @throws SQLException
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
     * Made by pepak16.
     * Changes the users firstname via his username and firstname.
     * @param username
     * @return boolean
     * @throws SQLException
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
     * Made by pepak16.
     * Changes the users lastname via his username and lastname.
     * @param username
     * @return boolean
     * @throws SQLException
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
     * Made by pepak16.
     * Changes the user type using the username and its corresponding type via the argument
     * @param username
     * @param type
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean setUserType(String username,String type) throws SQLException {
        Statement statement = con.createStatement();
        try {
            return statement.execute("UPDATE public.user SET role = '"+type+"' WHERE username = '"+username+"';");
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
     * Made by pepak16.
     * Checking if there exists any user with the provided username via the argument.
     * If there is already an existing user in database the operation will return true,
     * else it will return true.
     * @param username
     * @return boolean
     * @throws SQLException
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
     * Made by pepak16.
     * Checks whether the user is admin or not and return a truth value respectively.
     * @param username
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean isUserAdmin(String username) throws SQLException {
        Statement statement = con.createStatement();
        try {
            ResultSet resultset = statement.executeQuery("SELECT role FROM public.user WHERE username = '"+username+"';");
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

    //Project

    /**
     * Made by pepak16.
     * Adds new projects to the database, if the project isn't existing already.
     * @param name
     * @param description
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean addProject(String name,String description) throws SQLException {
        Statement statement = con.createStatement();
        try {
            ResultSet resultset = statement.executeQuery("INSERT INTO public.project VALUES '"+UUID.randomUUID()+"','"+name+"','"+description+"';");
            resultset.next();
            if (resultset.getString(1).equals("admin")) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("\nCaused by: project already exists in database.");
            return false;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    /**
     * Made by pepak16.
     * Fetches the project name via the given userid.
     * @param userid
     * @return boolean
     * @throws SQLException
     */
    @Override
    public String getProjectName(UUID userid) throws SQLException {
        Statement statement = con.createStatement();
        try {
            ResultSet resultset = statement.executeQuery(
                    "SELECT name from public.project" +
                            "  INNER JOIN UserProject ON projectId = fk_projectId" +
                            "  WHERE fk_userId = '"+userid+"'");
            while (resultset.next()) {
                return resultset.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("\nCaused by: project related to the userid doesn't exist in the database.");
            return null;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return null;
    }

    /**
     * Made by pepak16.
     * Fetches the project name via the given userid and name as argument.
     * @param projectid
     * @param name
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean setProjectName(UUID projectid,String name) throws SQLException {
        Statement statement = con.createStatement();
        try {
            statement.execute("UPDATE public.project SET name = '"+name+"' " +
                    "WHERE projectid = '"+projectid+"';");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("\nCaused by: project doesn't exist in the database.");
            return false;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    /**
     * Made by pepak16.
     * Fetches the project description via the given userid.
     * @param userid
     * @return boolean
     * @throws SQLException
     */
    @Override
    public String getProjectDescription(UUID userid) throws SQLException {
        Statement statement = con.createStatement();
        try {
            ResultSet resultset = statement.executeQuery(
                    "SELECT description from public.project" +
                            "  INNER JOIN UserProject ON projectId = fk_projectId\n" +
                            "  WHERE fk_userId = '"+userid+"'");
            while (resultset.next()) {
                return resultset.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("\nCaused by: project related to the userid doesn't exist in the database.");
            return null;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return null;
    }

    /**
     * Made by pepak16.
     * Changes the project description via the given userid and description as argument.
     * @param projectid
     * @param description
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean setProjectDescription(UUID projectid, String description) throws SQLException {
        Statement statement = con.createStatement();
        try {
            statement.execute("UPDATE public.project SET description = '"+description+"' WHERE projectid = '"+projectid+"';");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("\nCaused by: project related to the userid doesn't exist in the database.");
            return false;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    //Task
    @Override
    public boolean addTaskToProject(UUID taskid, String taskName, String taskdescription, String taskdue, String projectid) throws SQLException {
        Statement statement = con.createStatement();
        try {
            statement.execute("INSERT INTO task (taskId, taskName, taskDescription, taskStart, taskDue, fk_projectID, fk_statusId)\n" +
                    "VALUES ('"+taskid+"', '"+taskName+"', '"+taskdescription+"', 'CURDATE()', '"+taskdue+"', '"+projectid+"', '1');");
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

    @Override
    public boolean setTaskStatus(String taskid, int statusid) throws SQLException {
        Statement statement = con.createStatement();
        try {
            statement.executeQuery("UPDATE task\n" +
                    "SET taskStatus = '"+statusid+"'\n" +
                    "WHERE taskid = '"+taskid+"';");
            return true;
        } catch (SQLException e) {
            System.out.println("\nCaused by the task not existing.");
            return false;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    @Override
    public boolean deleteTask(String taskid) throws SQLException {
        Statement statement = con.createStatement();
        try {
            statement.executeQuery("DELETE FROM task\n" +
                    "WHERE taskid = '"+taskid+"';");
            return true;
        } catch (SQLException e) {
            System.out.println("\nCaused by the task not existing.");
            return false;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    @Override
    public boolean deleteAllTaskForProject(String projectid) throws SQLException {
        Statement statement = con.createStatement();
        try {
            statement.executeQuery("DELETE FROM task\n" +
                    "WHERE fk_projectid = '"+projectid+"';");
            return true;
        } catch (SQLException e) {
            System.out.println("\nCaused by the project not having any tasks.");
            return false;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    @Override
    public List getTaskByStatus(String projectid, int statusid) throws SQLException {
        return null;
    }

    @Override
    public List getAllTaskByProject(String projectid) throws SQLException {
        return null;
    }

}
