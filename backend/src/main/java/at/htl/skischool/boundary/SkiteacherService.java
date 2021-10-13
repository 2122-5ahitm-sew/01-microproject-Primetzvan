package at.htl.skischool.boundary;

import at.htl.skischool.entity.Skiteacher;
import at.htl.skischool.repository.SkiteacherRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/skiteacher")
@ApplicationScoped
public class SkiteacherService {

  @Inject
  SkiteacherRepository skiteacherRepository;

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


}
