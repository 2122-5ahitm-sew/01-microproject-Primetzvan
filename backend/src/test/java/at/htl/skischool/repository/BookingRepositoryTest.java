package at.htl.skischool.repository;

import at.htl.skischool.entity.*;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
class BookingRepositoryTest {

  @Inject
  public BookingRepository repo;

  @Inject
  public SkiteacherRepository skit;

  @Inject
  public SkistudentRepository skis;

  @Inject
  public CourseRepository cour;

  @Test
  void save() {

    Skiteacher teacher = new Skiteacher("Hans", "Müller", 55, 1430);
    Skistudent student = new Skistudent("Hans", "Müller", 10);
    Course course = new Course("Anfänger20-01-2022", Group.ANFAENGER, teacher);
    Booking booking = new Booking(student, course);

    repo.save(booking);

    long id = booking.getId();

    assertThat(repo.findById(id).getStudent().getLastname()).isEqualTo(booking.getStudent().getLastname());


  }

  @Test
  void delete() {

    Skiteacher teacher = new Skiteacher("Hans", "Müller", 55, 1430);
    Skistudent student = new Skistudent("Hans", "Müller", 10);
    Course course = new Course("Anfänger20-01-2022", Group.ANFAENGER, teacher);
    Booking booking = new Booking(student, course);

    repo.save(booking);

    Long id = booking.getId();

    repo.delete(id);

    assertThat(repo.findById(id)).isNull();

  }

/*  @Test
  void findAllBooking() {

    List<Booking> list = new ArrayList<>();
    List<Booking> repolist;

    Skiteacher teacher = new Skiteacher("Hans", "Müller", 55, 1430);
    skit.save(teacher);
    Skistudent student = new Skistudent("Hans", "Müller", 10);
    skis.save(student);
    Course course = new Course("Anfänger20-01-2022", Group.ANFAENGER, teacher);
    Course course1 = new Course("Koenner05-01-2021", Group.KOENNER, teacher);
    Course course2 = new Course("Profi05-01-2021", Group.PROFIS, teacher);

    cour.save(course);
    cour.save(course1);
    cour.save(course2);

    Booking booking1 = new Booking(student,course);
    Booking booking2 = new Booking(student,course1);
    Booking booking3 = new Booking(student,course2);

    repo.save(booking1);
    repo.save(booking2);
    repo.save(booking3);

    list.add(booking1);
    list.add(booking2);
    list.add(booking3);

    repolist = repo.findAll().list();

    assertThat(repolist).hasSize(list.size());

  }

  @Test
  void findById() {

    Long id;

    Skiteacher teacher = new Skiteacher("Hans", "Müller", 55, 1430);
    Skistudent student = new Skistudent("Hans", "Müller", 10);
    Course course = new Course("Anfänger20-01-2022", Group.ANFAENGER, teacher);
    Course course1 = new Course("Koenner05-01-2021", Group.KOENNER, teacher);
    Course course2 = new Course("Profi05-01-2021", Group.PROFIS, teacher);

    Booking booking1 = new Booking(student,course);
    Booking booking2 = new Booking(student,course1);
    Booking booking3 = new Booking(student,course2);

    repo.save(booking1);
    repo.save(booking2);
    repo.save(booking3);

    id = booking1.getId();

    Booking k = repo.findById(id);

    assertThat(k.getId()).isEqualTo(booking1.getId());


  }*/
}
