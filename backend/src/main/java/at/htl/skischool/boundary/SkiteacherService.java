package at.htl.skischool.boundary;

import at.htl.skischool.entity.Skiteacher;
import at.htl.skischool.repository.SkiteacherRepository;
import io.quarkus.security.identity.SecurityIdentity;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Path("/skiteacher")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@GraphQLApi
public class SkiteacherService {

  @Inject
  SkiteacherRepository skiteacherRepository;

  @Inject
  SecurityIdentity securityIdentity;

  @POST
  @RolesAllowed("teacher")
  @Path("addSkiteacher")
  @Transactional
  public void addSkiteacher(Skiteacher skiteacher){
    skiteacherRepository.save(skiteacher);
  }

  @GET
  @RolesAllowed("teacher")
  @Path("getAll")
  @Produces({MediaType.APPLICATION_JSON})
  public List<Skiteacher> getAll(){
    return this.skiteacherRepository.findAllSkiteacher();
  }

  @Query("allTeachers")
  @Description("Get all Teachers")
  public List<Skiteacher> getAllTeacher() {
    return skiteacherRepository.findAllSkiteacher();
  }

  @GET
  @RolesAllowed("teacher")
  @Path("getById/{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public Skiteacher getById(@PathParam("id") Long id){
    return this.skiteacherRepository.findById(id);
  }

  @Query
  @Description("Get all Teachers by Id")
  public Skiteacher getTeacherById(@Name("id") Long id) {
    return skiteacherRepository.findById(id);
  }

  @GET
  @Path("teacher")
  @RolesAllowed("teacher")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getUserInfo() {
    return Response.ok(
      Map.of("username", securityIdentity.getPrincipal().getName())
    ).build();
  }



}
