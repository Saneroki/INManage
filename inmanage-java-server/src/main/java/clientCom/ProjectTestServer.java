package main.java.clientCom;


import gen.java.model.Project;

public class ProjectTestServer {

    public static ProjectTestServer get(){
        return singleton;
    }

    public static final ProjectTestServer singleton = new ProjectTestServer();

    public String addProjectResponse(Project project){

        System.out.println(project.getId() + project.getDescription() + project.getName());

        String resp = "Succes!";

        return resp;

    }

}
