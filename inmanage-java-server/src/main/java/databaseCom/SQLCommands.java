package main.java.databaseCom;

import gen.java.model.Project;
import gen.java.model.Task;

import javax.xml.transform.Result;
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

    public static SQLCommands getInstance() throws SQLException {
        if (instance == null) {
            instance = new SQLCommands();
        }
        return instance;
    }







//PERSHA PERSHA PERSHA PERSHA, prep statements på alle metoder nedenunder!!!









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

    /**
     * Made by pepak16.
     * Checks whether the user is admin or not and return a truth value respectively.
     * @param checkUsername
     * @param checkPassword
     * @return boolean
     * @throws SQLException
     */
    @Override
    public String loginUser(String checkUsername, String checkPassword) throws SQLException {
        Statement statement = con.createStatement();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT userid FROM public.user WHERE username = '" + checkUsername + "' AND password = '" + checkPassword + "';");
            resultSet.next();
            return resultSet.getString(1);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    //Project

    /**
     * Made by pepak16.
     * Adds new project to the table project and respectively its association between
     * the user and project in the userproject table to the database, if the project isn't existing already.
     * @param userid
     * @param projectname
     * @param projectdescription
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean addProject(UUID userid, String projectname,String projectdescription) throws SQLException {
        Statement statement = con.createStatement();
        try {
            UUID projectid = UUID.randomUUID();
            boolean check = true;
            check = statement.execute("INSERT INTO public.project VALUES ('"+projectid+"','"+projectname+"','"+projectdescription+"');");
            if (!check) {
                statement.execute("INSERT INTO public.userproject VALUES ('"+UUID.randomUUID()+"','"+userid+"','"+projectid+"');");
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("\nCaused maybe by: project already exists in database.");
            return false;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    /**
     * Made by pepak16.
     * Adds new user to a specific project via the projectid to the database, if the user isn't already added to the project.
     * This is done via some checks that uses the private methods getUseridFromUsername() and checkIfUserProjectExist().
     * @param username
     * @param projectid
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean addUserToProject(String username,String projectid) throws SQLException {
        Statement statement = con.createStatement();
        try {
            String userid = getUseridFromUsername(username);
            if (!userid.equals(null)) {
                if (checkIfUserProjectExist(userid,projectid)) {
                    System.err.println("Brugeren er allerede tilføjet til projektet i forvejen!");
                    return false;
                } else {
                    System.out.println("Adder bruger til projektet nu.");
                    statement.execute("INSERT INTO public.userproject VALUES ('"+UUID.randomUUID()+"','"+userid+"','"+projectid+"');");
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("\nCaused maybe by: the user is already associated to the project.");
            return false;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return false;
    }







//OMAR OMAR OMAR OMAR, prep statements på alle metoder nedenunder!!!









    /**
     * Made by pepak16.
     * A private method to be used by the addUserToProject() method.
     * Fetches the userid via the given username from argument.
     * Temporary problem: can only fetch one row of userid associated with the username,
     * if the username has more than one userid associations.
     * @param username
     * @return String
     * @throws SQLException
     */
    private String getUseridFromUsername(String username) throws SQLException {
        Statement statement = con.createStatement();
        try {
            ResultSet resultset = statement.executeQuery("SELECT userid FROM public.user WHERE username = '"+username+"';");
            resultset.next();
            return resultset.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("\nCaused maybe by: the given username doesn't exist.\n");
            return null;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    /**
     * Made by pepak16.
     * Checks whether the a userid and projectid is associated in userproject table,
     * if yes then it would return true, else it would return false.
     * It would perhaps catch a PSQLException saying that
     * "ResultSet not positioned properly" the given userid or/and project is wrong.
     * @param userid
     * @param projectid
     * @return String
     * @throws SQLException
     */
    private boolean checkIfUserProjectExist(String userid, String projectid) throws SQLException {
        Statement statement = con.createStatement();
        try {
            boolean check;
            ResultSet resultset= statement.executeQuery("SELECT exists(SELECT fk_userId, fk_projectId FROM userproject WHERE fk_userId = '"+userid+"' AND fk_projectId = '"+projectid+"');");
            resultset.next();
            check = resultset.getBoolean(1);
            return check;
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
        List<Project> list = new ArrayList<>();
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

    /**
     * Made by pepak16.
     * Fetches the project description via the given userid.
     * @param userid
     * @return boolean
     * @throws SQLException
     */
    @Override
    public List<Project> getProject(UUID userid) throws SQLException {
        Statement statement = con.createStatement();
        List<Project> list = new ArrayList<>();
        Project project;
        try {
            ResultSet resultset = statement.executeQuery(
                    "SELECT * from public.project" +
                            "  INNER JOIN UserProject ON projectId = fk_projectId\n" +
                            "  WHERE fk_userId = '"+userid+"'");
            while (resultset.next()) {
                project = new Project();
                project.setId(resultset.getString(1));
                project.name(resultset.getString(2));
                project.setDescription(resultset.getString(3));
                project.setUserid(userid.toString());
                list.add(project);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("\nCaused by: project related to the userid doesn't exist in the database.");
            return null;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    //Task
    @Override
    public boolean addTaskToProject(String taskName, String taskdescription, String taskdue, String projectid) throws SQLException {
        Statement statement = con.createStatement();
        try {
            statement.execute("INSERT INTO task (taskId, taskName, taskDescription, taskStart, taskDue, fk_projectID, fk_statusId)\n" +
                    "VALUES ('"+UUID.randomUUID()+"', '"+taskName+"', '"+taskdescription+"', 'now()', '"+taskdue+"', '"+projectid+"', '1');");
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
        Statement statement = con.createStatement();
        try {
            statement.executeQuery("UPDATE task\n" +
                    "SET taskStatus = '"+statusId+"'\n" +
                    "WHERE taskId = '"+taskId+"';");
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
    public boolean deleteTask(String taskId) throws SQLException {
        Statement statement = con.createStatement();
        try {
            statement.executeQuery("DELETE FROM task\n" +
                    "WHERE taskId = '"+taskId+"';");
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
    public boolean deleteAllTaskForProject(String projectId) throws SQLException {
        Statement statement = con.createStatement();
        try {
            statement.executeQuery("DELETE FROM task\n" +
                    "WHERE fk_projectId = '"+projectId+"';");
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
        List<Task> tasksByProject = new ArrayList<>();        // ArrayList to hold tasks sorted by project.

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
                                tasksByProject.add(task);

            }



        } catch (SQLException e) {
            System.err.println("Error while getting tasks by project.");
            e.printStackTrace();
        }
        System.out.println("Returning: " + tasksByProject.toString());
        return tasksByProject;
    }

    //Test method

    public void printUser(String userName) throws SQLException {
        PreparedStatement ps = null;
        Statement s = null;
        try {
            ps = con.prepareStatement("SELECT * FROM public.user WHERE username = ?");
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            rs.next();
            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getString(4));
            System.out.println(rs.getString(5));
            System.out.println(rs.getString(6));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    //Test method

    public void printUserWithoutPS(String userName) throws SQLException {
        Statement s = null;
        try {
            s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM public.user WHERE username = '"+userName+"'");
            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
                System.out.println(rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }



}
