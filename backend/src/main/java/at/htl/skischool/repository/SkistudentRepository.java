package at.htl.skischool.repository;

import at.htl.skischool.entity.Skistudent;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class SkistudentRepository implements PanacheRepository<Skistudent> {

  public void save(Skistudent entity){

    if (entity.getId() != null){
      getEntityManager().merge(entity);
    }else {
      persist(entity);
    }
  }

  public void delete(long id){

    Skistudent skistudent = findById(id);

    if (skistudent != null){
      delete(skistudent);
    }

  }

  public List<Skistudent> findAllSkistudent(){
    var query = getEntityManager().createQuery("Select s from Skistudent s", Skistudent.class);
    return query.getResultList();
  }

  public Skistudent findById(long id){

    return find("id", id).firstResult();

  }

}
