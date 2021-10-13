package at.htl.skischool.repository;

import at.htl.skischool.entity.Booking;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class BookingRepository implements PanacheRepository<Booking> {

  public void save(Booking entity){

    if (entity.getId() != null){
      getEntityManager().merge(entity);
    }else {
      persist(entity);
    }
  }

  public void delete(long id){

    Booking booking = findById(id);

    if (booking != null){
      delete(booking);
    }

  }

  public List<Booking> findAllBooking(){
    var query = getEntityManager().createQuery("Select b from Booking b", Booking.class);
    return query.getResultList();
  }

  public Booking findById(long id){


    return find("id", id).firstResult();

  }


}
