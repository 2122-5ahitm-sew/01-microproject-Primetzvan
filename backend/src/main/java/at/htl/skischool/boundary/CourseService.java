package at.htl.skischool.boundary;

import at.htl.skischool.entity.Course;
import at.htl.skischool.repository.CourseRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/course")
@ApplicationScoped
public class CourseService {

  @Inject
  CourseRepository courseRepository;

  @POST
  @Path("addCourse")
  @Transactional
  public void addCourse(Course course){
    courseRepository.save(course);
  }

  @GET
  @Path("getAll")
  @Produces({MediaType.APPLICATION_JSON})
  public List<Course> getAll(){
    return this.courseRepository.findAllCourse();
  }

  @GET
  @Path("getById/{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public Course getById(@PathParam("id") Long id){
    return this.courseRepository.findById(id);
  }



}
