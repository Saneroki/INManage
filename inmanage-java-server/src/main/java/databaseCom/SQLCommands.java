package main.java.databaseCom;

import gen.java.model.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

    public static void main(String[] args) throws SQLException {

    }

    public static SQLCommands getInstance() throws SQLException {
        if (instance == null) {
            instance = new SQLCommands();
        }
        return instance;
    }

    /**
     * pepak16
     *
     * @param id
     * @param username
     * @param password
     * @param firstname
     * @param lastname
     * @param type
     * @return boolean
     * @throws SQLException Inserts the values from the argument into the table user in database
     *                      by executing an insert sql statement.
     */
    @Override
    public boolean registerUser(UUID id, String username, String password, String firstname, String lastname, String type) throws SQLException {
        Statement statement = con.createStatement();
        try {
            statement.execute("INSERT INTO public.user VALUES ('" + id + "','" + username + "','" + password + "','" + firstname + "','" + lastname + "','" + type + "');");
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
     *
     * @param username
     * @param password
     * @return boolean
     * @throws SQLException Checks whether the entered username and password matches in the database or
     *                      not and returns the truth values respectively.
     */
    @Override
    public boolean checkUserLogin(String username, String password) throws SQLException {
        Statement statement = con.createStatement();
        try {
            ResultSet resultset = statement.executeQuery("SELECT password FROM public.user WHERE username = '" + username + "';");
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
     *
     * @param username
     * @return String
     * @throws SQLException Gets password from the database via the username.
     */
    @Override
    public String getPassword(String username) throws SQLException {
        Statement statement = con.createStatement();
        try {
            ResultSet resultset = statement.executeQuery("SELECT password FROM public.user WHERE username = '" + username + "';");
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
     *
     * @param username
     * @return String
     * @throws SQLException Gets firstname from the database via the username.
     */
    @Override
    public String getFirstname(String username) throws SQLException {
        Statement statement = con.createStatement();
        try {
            ResultSet resultset = statement.executeQuery("SELECT firstname FROM public.user WHERE username = '" + username + "';");
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
            ResultSet resultset = statement.executeQuery("SELECT lastname FROM public.user WHERE username = '" + username + "';");
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
     *
     * @param username
     * @return boolean
     * @throws SQLException Use the argument for passing one or more information about the user
     */
    @Override
    public boolean setUsername(String username) throws SQLException {
        Statement statement = con.createStatement();
        try {
            statement.executeQuery("UPDATE public.user SET username = '" + username + "' WHERE username = '" + username + "';");
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
     *
     * @param username
     * @return boolean
     * @throws SQLException Use the argument for passing one or more information about the user
     */
    @Override
    public boolean setPassword(String username, String password) throws SQLException {
        Statement statement = con.createStatement();
        try {
            statement.executeQuery("UPDATE public.user SET password = '" + password + "' WHERE username = '" + username + "';");
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
     *
     * @param username
     * @return boolean
     * @throws SQLException Use the argument for passing one or more information about the user
     */
    @Override
    public boolean setFirstname(String username, String firstname) throws SQLException {
        Statement statement = con.createStatement();
        try {
            statement.executeQuery("UPDATE public.user SET firstname = '" + firstname + "' WHERE username = '" + username + "';");
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
     *
     * @param username
     * @return boolean
     * @throws SQLException Use the argument for passing one or more information about the user
     */
    @Override
    public boolean setLastname(String username, String lastname) throws SQLException {
        Statement statement = con.createStatement();
        try {
            statement.executeQuery("UPDATE public.user SET lastname = '" + lastname + "' WHERE username = '" + username + "';");
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
     *
     * @param username
     * @param type
     * @return boolean
     * @throws SQLException Changes the user type using the username and its corresponding type via the argument
     */
    @Override
    public boolean setUserType(String username, String type) throws SQLException {
        Statement statement = con.createStatement();
        try {
            return statement.execute("UPDATE public.user SET type = '" + type + "' WHERE username = '" + username + "';");
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
     * @throws SQLException Checking if there exists any user with the provided username via the argument.
     *                      If there is already an existing user in database the operation will return true,
     *                      else it will return true.
     */
    @Override
    public boolean isUserExisting(String username) throws SQLException {
        Statement statement = con.createStatement();
        try {
            ResultSet resultset = statement.executeQuery("SELECT username FROM public.user WHERE username = '" + username + "';");
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
     *
     * @param username
     * @return boolean
     * @throws SQLException Checks whether the user is admin or not and return a truth value respectively.
     */
    @Override
    public boolean isUserAdmin(String username) throws SQLException {
        Statement statement = con.createStatement();
        try {
            ResultSet resultset = statement.executeQuery("SELECT type FROM public.user WHERE username = '" + username + "';");
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Task
    @Override
    public boolean addTaskToProject(UUID taskId, String taskName, String taskDescription, String taskDue, String projectId) throws SQLException {
        Statement statement = con.createStatement();
        try {
            statement.execute("INSERT INTO task (taskId, taskName, taskDescription, taskStart, taskDue, taskStatus, fk_projectID)\n" +
                    "VALUES ('" + taskId + "', '" + taskName + "', '" + taskDescription + "', 'CURDATE()', '" + taskDue + "', '1', '" + projectId + "');");
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
    public boolean setTaskStatus(String taskId, int statusId) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteTask(String taskId) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteAllTaskForProject(String projectId) throws SQLException {
        return false;
    }


    /**
     * author: omhaw16
     */
    @Override
    public List getTaskByStatus(String projectId, int statusId) throws SQLException {
        List<Task> tasksByStatus = new ArrayList<>();       // Creation of ArrayList

        /** Explanation of the naming convention: **/
        /* 'Conv' at the end of the attribute name means it either
        * 1. Said information is already a string. This is the case with taskName and taskDesc.
        * 2. It's been converted to a String, hence CONV (short for 'converted).
        * /omhaw16
        */


        /* Start dates are just in case. They might be used later. /omhaw16

        Date taskStartByStatusOrig;     // Start date for said task. This is a Date.
        String taskStartByStatusConv;   // ... and here it's a String.

        */

        Date taskDueByStatusOrig;       // Due date for said task. This too is a date.
        String taskDueByStatusConv;     // ... and here it's a String.

        String taskProjectIDByStatusConv;  /* Project ID for said task. It's already in String format.
                                           * Tasks are sorted according to their status. */

        Statement statement = con.createStatement();        // Statement in order to use the SQL connection.

        try {

            ResultSet getTaskByStatusrs = statement.executeQuery("SELECT * FROM task\n" +
                    "INNER JOIN taskStatus ON fk_StatusId = statusId WHERE fk_projectId = '" + projectId + "' AND fk_statusId = '" + statusId + "';");

            Task task;

            while (getTaskByStatusrs.next()) {

                task = new Task();
                task.setName(getTaskByStatusrs.getString(2));               // Get task name as a String.
                task.setDescription(getTaskByStatusrs.getString(3));      // Get task desc. as a String.

                //  taskStartByStatusOrig = getTaskByStatusrs.getDate(4);       // Get task's start date as a Date.
                //  taskStartByStatusConv = taskStartByStatusOrig.toString();               // Convert taskStatus to String.

                taskDueByStatusOrig = getTaskByStatusrs.getDate(5);         // Get taskDue as a Date.
                taskDueByStatusConv = taskDueByStatusOrig.toString();                   // Convert taskDue to String.
                task.setDuedate(taskDueByStatusConv);                                   // Store due date (String) in the Task object.

                task.setId(getTaskByStatusrs.getString(6));  // Get taskProjectID as a String.

                // TODO ((Remove comment when task.setStatus() has been implemented in the model.Task.java.
                //task.setStatus(getTaskByStatusrs.getInt(7));       // Get taskStatus as an int.

                // Add all elements to an ArrayList, which will then be returned.
                // TODO Remember to add elements to the list.

                // TODO Remove the comment from this once task.setStatus is implemented in model.Task.java. /omhaw16
                // tasksByStatus.addAll());

                // For testing purposes, it's printed to the console.

                System.out.print("\n" + "Tasks sorted by status: " + tasksByStatus);

            }
            // When all elements have been traversed and added, return the list.

            return tasksByStatus;

        } catch (SQLException e) {          // In the case of any SQL error, catch the exception instance 'e'.

            // In said case, print out an error message.

            System.err.println("Error while getting tasks by status");

            // Print out the stack trace to make debugging easier.
            e.printStackTrace();

        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return tasksByStatus;
    }


    /**
     * author: omhaw16
     */
    public String getTaskNameByStatus(String projectId, int statusId) throws SQLException {

        Statement statement = con.createStatement();        // Statement in order to use the SQL connection.

        try {
            ResultSet getTaskByStatusrs = statement.executeQuery("SELECT taskName FROM task WHERE fk_projectId = '" + projectId + "' AND fk_statusId = '" + statusId + "';");
            getTaskByStatusrs.next();
            return getTaskByStatusrs.getString(1);

        } catch (SQLException e) {
            System.err.println("Error while fetching task name.");
            e.printStackTrace();
            return null;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    /**
     * author: omhaw16
     */
    public List getAllTaskByProject(String projectId) throws SQLException {
        List<String> tasksByProject = new ArrayList<>();        // ArrayList to hold tasks sorted by project.

        /** Explanation of the naming convention: **/
        /* 'Conv' at the end of the attribute name means it either
        * 1. Said information is already a string
        *                   or
        * 2. It's been converted to a String, hence CONV (short for 'converted).
        * /omhaw16
        */

        Date taskStartOrig;
        String taskStartConv; // just in case /omhaw16

        Date taskDueOrig;
        String taskDueConv;


        try {

            Statement statement = con.createStatement();
            ResultSet getTaskByProjrs = statement.executeQuery("SELECT * FROM task\n" +
                    "INNER JOIN project ON fk_projectId = projectId WHERE fk_projectId = '" + projectId + "';");

            Task task;

            while (getTaskByProjrs.next()) {
                task = new Task();

                task.setName(getTaskByProjrs.getString(2));         // Get task name as a String. Assign to Task object.
                task.setDescription(getTaskByProjrs.getString(3));  // Get task desc. as a String. Assign to Task object.

                //        taskStartOrig = getTaskByProjrs.getDate(4);                // Get the start date.
                //        taskStartConv = taskStartOrig.toString();                // Convert start date to String. (just in case)

                taskDueOrig = getTaskByProjrs.getDate(5);   // Get task date as a Date.
                taskDueConv = taskDueOrig.toString();                   // Convert task date to a String.
                task.setDuedate(taskDueConv);                           // Assign task due date (String) to the Task object.

                task.setId(getTaskByProjrs.getString(6));   // Get project ID for specified task
                // & assign it to the task object.


                // TODO ((Remove comment when task.setStatus() has been implemented in model.Task.java. /omhaw16
                //task.setStatus(getTaskByProjrs.getInt(7));       // Get taskStatus as an int.

                // Add all elements to an ArrayList, which will then be returned.
                // TODO Remember to add elements to the list.

                // TODO Remove the comment from this once task.setStatus is implemented in model.Task.java. /omhaw16
                //                tasksByProject.addAll();
                System.out.println("Tasks sorted by project: " + tasksByProject);
            }


        } catch (SQLException e) {
            System.err.println("Error while getting tasks by project.");
            e.printStackTrace();
        }
        return tasksByProject;
    }

}

