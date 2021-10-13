package at.htl.skischool.boundary;

import at.htl.skischool.entity.Skistudent;
import at.htl.skischool.repository.SkistudentRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/skistudent")
@ApplicationScoped
public class SkistudentService {

  @Inject
  SkistudentRepository skistudentRepository;

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


}
