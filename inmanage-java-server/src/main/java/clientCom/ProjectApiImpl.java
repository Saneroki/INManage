package main.java.clientCom;

import gen.java.api.ApiResponseMessage;
import gen.java.api.NotFoundException;
import gen.java.api.ProjectApiService;
import gen.java.model.Project;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

public class ProjectApiImpl extends ProjectApiService {
    @Override
    public Response addProject(Project project, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(INManageServer.get().addProjectResponse(project)).build();
    }

    @Override
    public Response addUserToProject(String projectID, String theIDOfTheUserMakingTheOperation, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(INManageServer.get().addUserToProjectResponse(projectID,theIDOfTheUserMakingTheOperation)).build();
    }

    @Override
    public Response deleteProject(String projectId, String passWord, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(INManageServer.get().deleteProjectResponse(projectId,passWord)).build();
    }

    @Override
    public Response editProject(Project projectObject, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(INManageServer.get().editProjectResponse(projectObject)).build();
    }

    @Override
    public Response getAllProjects(String userId, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(INManageServer.get().getProjectsResponse(userId)).build();

    }

    @Override
    public Response getSpecificProject(String projectID, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(INManageServer.get().getSpecificProjectResponse(projectID)).build();
    }


    @Override
    public Response getUserAmount(String projectId, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(INManageServer.get().getUserAmountResponse(projectId)).build();
    }
}
