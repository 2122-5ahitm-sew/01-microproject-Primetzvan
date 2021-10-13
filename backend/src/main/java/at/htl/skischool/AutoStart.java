package at.htl.skischool;

import at.htl.skischool.entity.*;
import at.htl.skischool.repository.BookingRepository;
import at.htl.skischool.repository.CourseRepository;
import at.htl.skischool.repository.SkistudentRepository;
import at.htl.skischool.repository.SkiteacherRepository;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class AutoStart {

  @Inject
  SkistudentRepository skistudentRepository;
  @Inject
  SkiteacherRepository skiteacherRepository;
  @Inject
  CourseRepository courseRepository;
  @Inject
  BookingRepository bookingRepository;

  @Transactional
  void startup(@Observes StartupEvent event) {

    System.out.println("It works!");
    Skistudent skistudent = new Skistudent("vani", "prim", 19);
    Skistudent skistudent1 = new Skistudent("marah", "ste", 17);

    Skiteacher skiteacher = new Skiteacher("Lisa", "Mueller", 21, 1000);
    Skiteacher skiteacher1 = new Skiteacher("Bernd", "Mueller", 21, 1000);

    Course course = new Course("Anfaenger", Group.ANFAENGER, skiteacher);
    Course course1 = new Course("Koenner", Group.KOENNER, skiteacher);

    Booking booking = new Booking(skistudent, course);
    Booking booking1 = new Booking(skistudent1, course);

    skistudentRepository.save(skistudent);
    skistudentRepository.save(skistudent1);
    skiteacherRepository.save(skiteacher);
    skiteacherRepository.save(skiteacher1);
    courseRepository.save(course);
    courseRepository.save(course1);
    bookingRepository.save(booking);
    bookingRepository.save(booking1);


  }

}
