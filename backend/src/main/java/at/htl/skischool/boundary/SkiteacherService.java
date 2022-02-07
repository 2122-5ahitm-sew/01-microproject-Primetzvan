package at.htl.skischool.boundary;

import at.htl.skischool.entity.Skiteacher;
import at.htl.skischool.repository.SkiteacherRepository;
import io.quarkus.security.identity.SecurityIdentity;

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
public class SkiteacherService {

  @Inject
  SkiteacherRepository skiteacherRepository;

  @Inject
  SecurityIdentity securityIdentity;

  @POST
  @Path("addSkiteacher")
  @Transactional
  public void addSkiteacher(Skiteacher skiteacher){
    skiteacherRepository.save(skiteacher);
  }

  @GET
  @Path("getAll")
  @Produces({MediaType.APPLICATION_JSON})
  public List<Skiteacher> getAll(){
    return this.skiteacherRepository.findAllSkiteacher();
  }

  @GET
  @Path("getById/{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public Skiteacher getById(@PathParam("id") Long id){
    return this.skiteacherRepository.findById(id);
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
