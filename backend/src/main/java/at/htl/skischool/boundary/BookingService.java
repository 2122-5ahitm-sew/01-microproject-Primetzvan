package at.htl.skischool.boundary;

import at.htl.skischool.entity.Booking;
import at.htl.skischool.repository.BookingRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/booking")
@ApplicationScoped
public class BookingService {

  @Inject
  BookingRepository bookingRepository;

  @POST
  @Path("addBooking")
  @Transactional
  public void addBooking(Booking booking){
    bookingRepository.save(booking);
  }

  @GET
  @Path("getAll")
  @Produces({MediaType.APPLICATION_JSON})
  public List<Booking> getAll(){
    return this.bookingRepository.findAllBooking();
  }

  @GET
  @Path("getById/{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public Booking getById(@PathParam("id") Long id){
    return this.bookingRepository.findById(id);
  }

}
