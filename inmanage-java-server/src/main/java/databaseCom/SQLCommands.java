package main.java.databaseCom;

import gen.java.model.Project;
import gen.java.model.Task;
import gen.java.model.User;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.lang.reflect.Member;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.sql.Date;

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
     * Author: pepak16.
     * Inserts the values from the argument into the table user in database
     * by executing an insert sql statement.
     * @param username
     * @param password
     * @param firstname
     * @param lastname
     * @param type
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean addUser(String username, String password, String firstname, String lastname, String type) throws SQLException {
        PreparedStatement ps = null;
        try {
            if (!isUserExisting(username)) {
                ps = con.prepareStatement("INSERT INTO public.user VALUES (?,?,?,?,?,?);");
                ps.setObject(1, UUID.randomUUID());
                ps.setString(2, username);
                ps.setString(3, password);
                ps.setString(4, firstname);
                ps.setString(5, lastname);
                ps.setString(6, type);
                ps.execute();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Deletes user via its userid and password for authentification. If user exists and the authentification goes through,
     * then it would delete the user and return true, else it would return false.
     * @param userid
     * @param password
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean deleteUser(String userid, String password) throws SQLException {
        PreparedStatement ps = null;
        try {
            String username = getUsernameFromUserid(userid);
            if (isUserExisting(username)) {
                if (authentificatePassword(username,password)) {
                    ps = con.prepareStatement("DELETE FROM public.user WHERE userid = ? AND password = ?;");
                    ps.setObject(1,UUID.fromString(userid));
                    ps.setString(2,password);
                    ps.execute();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16
     * Authentificate user password and returning a true value, if login informations exists.
     * @param username
     * @param password
     * @return boolean
     * @throws SQLException
     */
    private boolean authentificatePassword(String username, String password) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT EXISTS (SELECT userid FROM public.user WHERE username = ? AND password = ?);");
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getBoolean(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Searching the whole database for users by the searchString variable.
     * It will find the corresponding searchString string in each username it goes through and
     * if the username contains the searchString, it will add it and return it in as a list.
     * @param searchString
     * @return boolean
     * @throws SQLException
    */
    @Override
    public List<User> searchUser(String searchString) throws SQLException {
        PreparedStatement ps = null;
        ArrayList<User> userList;
        User user = null;
        try {
            userList = new ArrayList<>();
            ps = con.prepareStatement("SELECT username,firstname,lastname FROM public.user;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).contains(searchString)) {
                //To find the first occurence of a string, use the if statement below instead.
                //if (searchString.indexOf(rs.getString(1)) > -1) {
                    user = new User();
                    user.setName(rs.getString(1));
                    user.setFirstName(rs.getString(2));
                    user.setLastName(rs.getString(3));
                    userList.add(user);
                }
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Gets password from the database via the userid.
     * @param userid
     * @return String
     * @throws SQLException
     */
    @Override
    public String getPassword(String userid) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT password FROM public.user WHERE userid = ?;");
            ps.setObject(1,UUID.fromString(userid));
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Gets firstname from the database via the userid.
     * @param userid
     * @return String
     * @throws SQLException
     */
    @Override
    public String getFirstname(String userid) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT firstname FROM public.user WHERE userid = ?;");
            ps.setObject(1,UUID.fromString(userid));
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Gets lastname from the database via the userid.
     * @param userid
     * @return String
     * @throws SQLException
     */
    @Override
    public String getLastname(String userid) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT lastname FROM public.user WHERE userid = ?;");
            ps.setObject(1,UUID.fromString(userid));
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Changes the username of the user via his username.
     * @param userid
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean editUsername(String userid, String newUsername) throws SQLException {
        PreparedStatement ps = null;
        try {
            if (!checkIfUsernameExist(newUsername)) {
                ps = con.prepareStatement("UPDATE public.user SET username = ? WHERE userid = ?;");
                ps.setString(1, newUsername);
                ps.setObject(2, UUID.fromString(userid));
                ps.execute();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Checks if the given username already exist.
     * @param username
     * @return boolean
     * @throws SQLException
     */
    private boolean checkIfUsernameExist(String username) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT EXISTS (SELECT * FROM public.user WHERE username = ?);");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getBoolean(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Changes the users password via his username and password.
     * @param username
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean editPassword(String username, String password) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("UPDATE public.user SET password = ? WHERE username = ?;");
            ps.setString(1, password);
            ps.setString(2, username);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Edits the users firstname via his username and firstname.
     * @param username
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean editFirstname(String username, String firstname) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("UPDATE public.user SET firstname = ? WHERE username = ?;");
            ps.setString(1, firstname);
            ps.setString(2, username);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Edits the users lastname via his username and lastname.
     * @param username
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean editLastname(String username, String lastname) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("UPDATE public.user SET lastname = ? WHERE username = ?;");
            ps.setString(1, lastname);
            ps.setString(2, username);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Edits the user type using the username and its corresponding type via the argument.
     * @param username
     * @param type
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean editUserType(String username, String type) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("UPDATE public.user SET role = ? WHERE username = ?;");
            ps.setString(1, type);
            ps.setString(2, username);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Checking if there exist any user with the provided username via the argument.
     * If there is already an existing user in database the operation will return true,
     * else it will return false.
     * @param username
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean isUserExisting(String username) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT EXISTS (SELECT username FROM public.user WHERE username = ?);");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            rs.next();
            if (rs.getBoolean(1)) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Checks whether the user is admin or not and return a truth value respectively.
     * @param username
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean isUserAdmin(String username) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT role FROM public.user WHERE username = ?;");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            rs.next();
            if (rs.getString(1).equalsIgnoreCase("admin")) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: malta16, pepak16.
     * Logging the user in using its username and password, if the given credentials exist already.
     * @param username
     * @param password
     * @return boolean
     * @throws SQLException
     */
    @Override
    public String loginUser(String username, String password) throws SQLException {
        PreparedStatement ps = null;
        try {
            if (isUserExisting(username)) {
                ps = con.prepareStatement("SELECT userid FROM public.user WHERE username = ? AND password = ?;");
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                rs.next();
                return rs.getString(1);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    //Project

    /**
     * Author: pepak16.
     * Adds new project to the table project and respectively its association between
     * the user and project in the userproject table to the database, if the project isn't existing already.
     * @param userid
     * @param projectname
     * @param projectdescription
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean addProject(String userid, String projectname, String projectdescription) throws SQLException {
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        try {
            UUID projectid = UUID.randomUUID();
            ps1 = con.prepareStatement("INSERT INTO public.project VALUES (?,?,?);");
            ps2 = con.prepareStatement("INSERT INTO public.userproject VALUES (?,?,?);");

            con.setAutoCommit(false);

            ps1.setObject(1, projectid);
            ps1.setString(2, projectname);
            ps1.setString(3, projectdescription);
            ps1.addBatch();
            ps1.executeBatch();

            ps2.setObject(1, UUID.randomUUID());
            ps2.setObject(2, UUID.fromString(userid));
            ps2.setObject(3, projectid);
            ps2.addBatch();
            ps2.executeBatch();
            con.commit();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps1 != null) {
                ps1.close();
            }
            if (ps2 != null) {
                ps2.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Deletes a project with its associated tasks and users of the projects via the projectid,
     * if the project exists already, else it will return false.
     * @param projectid
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean deleteProject(String projectid) throws SQLException {
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        try {
            if (checkIfProjectExist(projectid)) {
                ps1 = con.prepareStatement("DELETE FROM public.project WHERE projectid = ?;");
                ps2 = con.prepareStatement("DELETE FROM public.userproject WHERE fk_projectid = ?;");

                con.setAutoCommit(false);

                ps1.setObject(1,UUID.fromString(projectid));
                ps1.addBatch();
                ps1.executeBatch();

                ps2.setObject(1,UUID.fromString(projectid));
                ps2.addBatch();
                ps2.executeBatch();

                con.commit();
                if (checkIfProjectTaskExist(projectid)) {
                    deleteAllTaskForProject(projectid);
                }
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps1 != null) {
                ps1.close();
            }
            if (ps2 != null) {
                ps2.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Checks if a project already exists.
     * @param projectid
     * @return boolean
     * @throws SQLException
     */
    private boolean checkIfProjectExist(String projectid) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT EXISTS (SELECT * FROM project WHERE projectid = ?);");
            ps.setObject(1,UUID.fromString(projectid));
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getBoolean(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Adds new user to a specific project via the projectid to the database, if the user isn't already added to the project.
     * This is done via some checks that uses the private methods getUseridFromUsername() and checkIfUserProjectExist().
     * @param username
     * @param projectid
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean addUserToProject(String username, String projectid) throws SQLException {
        PreparedStatement ps = null;
        try {
            String userid = getUseridFromUsername(username);
            if (!userid.equals(null)) {
                if (checkIfUserProjectExist(userid, projectid)) {
                    return false;
                } else {
                    ps = con.prepareStatement("INSERT INTO public.userproject VALUES (?,?,?);");
                    ps.setObject(1, UUID.randomUUID());
                    ps.setObject(2, UUID.fromString(userid));
                    ps.setObject(3, UUID.fromString(projectid));
                    ps.execute();
                    return true;
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * A private method to be used by the addUserToProject() method.
     * Gets the userid via the given username as an argument.
     * @param username
     * @return String
     * @throws SQLException
     */
    private String getUseridFromUsername(String username) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT userid FROM public.user WHERE username = ?;");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Gets username by userid.
     * @param userid
     * @return String
     * @throws SQLException
     */
    private String getUsernameFromUserid(String userid) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT username FROM public.user WHERE userid = ?;");
            ps.setObject(1, UUID.fromString(userid));
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            return null;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    // userid, projectid

    /**
     * Author: pepak16.
     * Checks whether the a userid and projectid is associated in userproject table,
     * if yes then it would return true, else it would return false.
     * @param userid
     * @param projectid
     * @return String
     * @throws SQLException
     */
    private boolean checkIfUserProjectExist(String userid, String projectid) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT exists(SELECT * FROM userproject WHERE fk_userId = ? AND fk_projectId = ?);");
            ps.setObject(1, UUID.fromString(userid));
            ps.setObject(2, UUID.fromString(projectid));
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getBoolean(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }


    /**
     * Author: pepak16.
     * Gets the project name via the given userid.
     * @param userid
     * @return boolean
     * @throws SQLException
     */
    @Override
    public String getProjectName(String userid) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(
                    "SELECT name from public.project" +
                            "  INNER JOIN UserProject ON projectId = fk_projectId" +
                            "  WHERE fk_userId = ?;");
            ps.setObject(1, UUID.fromString(userid));
            ResultSet rs = ps.executeQuery();
            return rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Fetches the project name via the given userid and name as argument.
     * @param projectid
     * @param name
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean editProjectName(String projectid, String name) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("UPDATE public.project SET name = ? " +
                    "WHERE projectid = ?;");
            ps.setString(1, name);
            ps.setObject(2, UUID.fromString(projectid));
            ps.execute();
            System.out.println("Edited project name: " + name);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Gets the project description via the given userid.
     * @param userid
     * @return boolean
     * @throws SQLException
     */
    @Override
    public String getProjectDescription(String userid) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(
                    "SELECT description from public.project" +
                            "  INNER JOIN UserProject ON projectId = fk_projectId\n" +
                            "  WHERE fk_userId = ?;");
            ps.setObject(1, UUID.fromString(userid));
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Edits the project description.
     * @param projectid
     * @param description
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean editProjectDescription(String projectid, String description) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("UPDATE public.project SET description = ? WHERE projectid = ?;");
            ps.setString(1, description);
            ps.setObject(2, UUID.fromString(projectid));
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Gets all projects associated to the userid and returning them as a list containg Project objects.
     * @param userid
     * @return boolean
     * @throws SQLException
     */
    @Override
    public List<Project> getProject(String userid) throws SQLException {
        PreparedStatement ps = null;
        List<Project> list = new ArrayList<>();
        Project project;
        try {
            ps = con.prepareStatement(
                    "SELECT * from public.project" +
                            "  INNER JOIN UserProject ON projectId = fk_projectId\n" +
                            "  WHERE fk_userId = ?;");
            ps.setObject(1, UUID.fromString(userid));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                project = new Project();
                project.setId(rs.getString(1));
                project.name(rs.getString(2));
                project.setDescription(rs.getString(3));
                project.setUserid(userid.toString());
                list.add(project);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: omhaw16, pepak16
     * Adds a task to a project. Before it adds the task,
     * it parses the String to a Date type to pass it as an sql statement.
     * @param taskName
     * @param taskdescription
     * @param taskdue
     * @param projectid
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean addTaskToProject(String taskName, String taskdescription, String taskdue, String projectid) throws SQLException {
        PreparedStatement ps = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate;
        java.sql.Date sqlTaskDue;
        try {
            utilDate = sdf.parse(taskdue);
            sqlTaskDue = new Date(utilDate.getTime());
            ps = con.prepareStatement("INSERT INTO task VALUES (?, ?, ?, now(), ?, ?, 1);");
            ps.setObject(1, UUID.randomUUID());
            ps.setString(2, taskName);
            ps.setString(3, taskdescription);
            ps.setDate(4, sqlTaskDue);
            ps.setObject(5, UUID.fromString(projectid));
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Edits the task name.
     * @param taskid
     * @param taskname
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean editTaskName(String taskid, String taskname) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("UPDATE task SET taskname = ? WHERE taskid = ?;");
            ps.setString(1,taskname);
            ps.setObject(2,UUID.fromString(taskid));
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Edits the task description.
     * @param taskid
     * @param taskdescription
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean editTaskDescription(String taskid, String taskdescription) throws SQLException {
        PreparedStatement ps = null;
        try {
            System.out.println("taskid: " + taskid);
            System.out.println("task desc: " + taskdescription);
            ps = con.prepareStatement("UPDATE task SET taskdescription = ? WHERE taskid = ?;");
            ps.setString(1,taskdescription);
            ps.setObject(2,UUID.fromString(taskid));
            System.out.println("Task edited");
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Edits the taskdue date.
     * Parses the taskdue as string to Date format before it edits the date.
     * @param taskid
     * @param taskdue
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean editTaskDue(String taskid, String taskdue) throws SQLException {
        PreparedStatement ps = null;
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate;
        java.sql.Date sqlTaskDue;
        try {
            utilDate = sdf1.parse(taskdue);
            sqlTaskDue = new Date(utilDate.getTime());
            ps = con.prepareStatement("UPDATE task SET taskdue = ? WHERE taskid = ?;");
            ps.setDate(1,sqlTaskDue);
            ps.setObject(2,UUID.fromString(taskid));
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Edits the projectid associated to the task to move a task to another project.
     * @param taskid
     * @param projectid
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean editTaskToProject(String taskid, String projectid) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("UPDATE task SET fk_projectid = ? WHERE taskid = ?;");
            ps.setObject(1,UUID.fromString(projectid));
            ps.setObject(2,UUID.fromString(taskid));
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Edits task status (flag) by the entered statusid.
     * @param taskId
     * @param statusId
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean editTaskStatus(String taskId, int statusId) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("UPDATE task SET taskStatus = ? WHERE taskId = ?;");
            ps.setInt(1, statusId);
            ps.setObject(2, UUID.fromString(taskId));
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Deletes a task using the taskid.
     * @param taskId
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean deleteTask(String taskId) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("DELETE FROM task WHERE taskId = ?;");
            ps.setObject(1, UUID.fromString(taskId));
            ps.execute();
            System.out.println("Task deleted, id: " + taskId);
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Deletes all tasks in a specific project using its projectid.
     * @param projectId
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean deleteAllTaskForProject(String projectId) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("DELETE FROM task WHERE fk_projectId = ?;");
            ps.setObject(1,UUID.fromString(projectId));
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: pepak16.
     * Checks if a task associated to the projectid exists. If not it will return false.
     * @param projectid
     * @return boolean
     * @throws SQLException
     */
    private boolean checkIfProjectTaskExist(String projectid) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT EXISTS (SELECT * FROM task WHERE fk_projectid = ?);");
            ps.setObject(1,UUID.fromString(projectid));
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getBoolean(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * author: omhaw16
     * Gets all tasks by its associated projectid and statusid and returning it as a list containing Task objects.
     * @param projectId
     * @param statusId
     * @return List
     * @throws SQLException
     */
    @Override
    public List<Task> getTaskByStatus(String projectId, int statusId) throws SQLException {
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
        PreparedStatement ps = null;        // Statement in order to use the SQL connection.

        try {

            ps = con.prepareStatement("SELECT * FROM task\n" +
                    "INNER JOIN taskStatus ON fk_StatusId = statusId WHERE fk_projectId = ? AND fk_statusId = ?;");
            ps.setObject(1, UUID.fromString(projectId));
            ps.setInt(2, statusId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Task task = new Task();
                task.setName(rs.getString(2));               // Get task name as a String.
                task.setDescription(rs.getString(3));      // Get task desc. as a String.

                //  taskStartByStatusOrig = getTaskByStatusrs.getDate(4);       // Get task's start date as a Date.
                //  taskStartByStatusConv = taskStartByStatusOrig.toString();               // Convert taskStatus to String.

                taskDueByStatusOrig = rs.getDate(5);         // Get taskDue as a Date.
                taskDueByStatusConv = taskDueByStatusOrig.toString();                   // Convert taskDue to String.
                task.setDuedate(taskDueByStatusConv);                                   // Store due date (String) in the Task object.

                task.setId(UUID.fromString(rs.getString(6)));  // Get taskProjectID as a String.

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
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }


    /**
     * Author: omhaw16
     * Gets task name by the its associating projectid and statusid.
     * @param projectId
     * @param statusId
     * @return String
     * @throws SQLException
     */
    @Override
    public String getTaskNameByStatus(String projectId, int statusId) throws SQLException {
        PreparedStatement ps = null;        // Statement in order to use the SQL connection.
        try {
            ps = con.prepareStatement("SELECT taskName FROM task WHERE fk_projectId = ? AND fk_statusId = ?;");
            ps.setObject(1, projectId);
            ps.setObject(2, statusId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: omhaw16
     * Gets all the tasks by projectid as a list containg objects of task.
     * @param projectId
     * @return List<Task>
     * @throws SQLException
     */
    @Override
    public List<Task> getAllTaskByProject(String projectId) throws SQLException {
        List<Task> taskList;       // ArrayList to hold tasks sorted by project.

        /** Explanation of the naming convention: **/
        /* 'Conv' at the end of the attribute name means it either
        * 1. Said information is already a string
        *                   or
        * 2. It's been converted to a String, hence CONV (short for 'converted).
        * /omhaw16
        */
        Date taskDueOrig;
        String taskDueConv;

        PreparedStatement ps = null;        // Statement in order to use the SQL connection.
        Task task;

        try {
            taskList = new ArrayList<>();
            ps = con.prepareStatement("SELECT * FROM task INNER JOIN project ON fk_projectId = projectId WHERE fk_projectId = ?;");
            ps.setObject(1, UUID.fromString(projectId));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                task = new Task();
                task.setName(rs.getString(2));         // Get task name as a String. Assign to Task object.
                task.setDescription(rs.getString(3));  // Get task desc. as a String. Assign to Task object.
                taskDueOrig = rs.getDate(5);   // Get task date as a Date.
                taskDueConv = taskDueOrig.toString();                   // Convert task date to a String.
                task.setDuedate(taskDueConv);                           // Assign task due date (String) to the Task object.
                task.setId(UUID.fromString(rs.getString(1)));   // Get task ID for specified task
                task.setStatus(rs.getString(7));
                // & assign it to the task object.

                //task.setStatus(getTaskByProjrs.getInt(7));       // Get taskStatus as an int.

                // Add all elements to an ArrayList, which will then be returned.

                taskList.add(task);
            }
            return taskList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: omhaw16
     * Gets the specific user by its userid and returning an user object.
     * @param userid
     * @return User
     * @throws SQLException
     */
    @Override
    public User getSpecificUser(String userid) throws SQLException {
        PreparedStatement ps = null;
        User user;
        try {
            ps = con.prepareStatement("SELECT * from public.user WHERE userId = ?;");
            ps.setObject(1, UUID.fromString(userid));
            ResultSet rs = ps.executeQuery();
            rs.next();
            user = new User();
            user.setId(UUID.fromString(rs.getString(1)));
            user.setName(rs.getString(2));
            user.setFirstName(rs.getString(4));
            user.setLastName(rs.getString(5));
            user.setPassword(rs.getString(3));
            System.out.println("Returning user: " + user.getName());
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: omhaw16
     * Gets the amount of tasks in a project using the projectid.
     * @param projectId
     * @return int
     * @throws SQLException
     */
    @Override
    public int getTaskAmount(String projectId) throws SQLException {
        PreparedStatement ps = null;
        int count;
        try {
            ps = con.prepareStatement("SELECT COUNT(*) AS count_task from public.task WHERE fk_projectId = ?;");
            ps.setObject(1, UUID.fromString(projectId));
            ResultSet rs = ps.executeQuery();
            rs.next();
            count = rs.getInt("count_task");
            System.out.println("Count: " + count);
            return count;
        } catch (SQLException e) {
            System.err.println("Error getting taskAmount count.");
            e.printStackTrace();
            return 0;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: omhaw16
     * Gets the amount of users contributing in a specific project by the projectid.
     * @param projectId
     * @return List<Task>
     * @throws SQLException
     */
    @Override
    public int getUserAmount(String projectId) throws SQLException {
        PreparedStatement ps = null;
        int count = 0;
        try {
            ps = con.prepareStatement("SELECT COUNT(fk_userid) AS count_users FROM public.userproject WHERE fk_projectId = ?;");
            ps.setObject(1, UUID.fromString(projectId));
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Author: omhaw16
     * Gets the specific project by the projectid and returning an object.
     * @param projectId
     * @return Project
     * @throws SQLException
     */
    @Override
    public Project getSpecificProject(String projectId) throws SQLException {
        PreparedStatement ps = null;
        Project project;
        try {
            ps = con.prepareStatement("SELECT * FROM public.project WHERE projectid = ?;");
            ps.setObject(1, UUID.fromString(projectId));
            ResultSet rs = ps.executeQuery();
            rs.next();
            project = new Project();
            project.setName(rs.getString(2));
            project.setDescription(rs.getString(3));
            return project;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

}
