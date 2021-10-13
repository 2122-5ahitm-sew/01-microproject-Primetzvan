package at.htl.skischool.repository;

import at.htl.entity.Course;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class CourseRepository implements PanacheRepository<Course> {

  public void save(Course entity){

    if (entity.getId() != null){
      getEntityManager().merge(entity);
    }else {
      persist(entity);
    }
  }

  public void delete(long id){

    Course course = findById(id);

    if (course != null){
      delete(course);
    }

  }

  public List<Course> findAllCourse(){
    var query = getEntityManager().createQuery("Select c from Course c", Course.class);
    return query.getResultList();
  }

  public Course findById(long id){

    return find("id", id).firstResult();


  }

}
