package at.htl.skischool.repository;

import at.htl.entity.Skiteacher;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class SkiteacherRepository implements PanacheRepository<Skiteacher> {

  public void save(Skiteacher entity){

    if (entity.getId() != null){
      getEntityManager().merge(entity);
    }else {
      persist(entity);
    }

  }

  public void delete(long id){

    Skiteacher skiteacher = findById(id);

    if (skiteacher != null){
      delete(skiteacher);
    }

  }


  public Skiteacher findById(long id){

    return find("id", id).firstResult();

  }

  public List<Skiteacher> findAllSkiteacher() {
    var query = getEntityManager().createQuery("Select s from Skiteacher s", Skiteacher.class);
    return query.getResultList();
  }

}
