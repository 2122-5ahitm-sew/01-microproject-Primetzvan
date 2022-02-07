package at.htl.skischool.boundary;

import at.htl.skischool.entity.Skistudent;
import at.htl.skischool.repository.SkistudentRepository;
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

@Path("/skistudent")
@ApplicationScoped
public class SkistudentService {

  @Inject
  SkistudentRepository skistudentRepository;

  @Inject
  SecurityIdentity securityIdentity;

  @POST
  @Path("addSkistuden")
  @Transactional
  public void addSkistudent(Skistudent skistudent){
    skistudentRepository.save(skistudent);
  }

  @GET
  @Path("getAll")
  @Produces({MediaType.APPLICATION_JSON})
  public List<Skistudent> getAll(){
    return this.skistudentRepository.findAllSkistudent();
  }

  @GET
  @Path("getById/{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public Skistudent getById(@PathParam("id") Long id){
    return this.skistudentRepository.findById(id);
  }

  @GET
  @Path("students")
  @RolesAllowed("student")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getUserInfo() {
    return Response.ok(
      Map.of("username", securityIdentity.getPrincipal().getName())
    ).build();
  }

}
