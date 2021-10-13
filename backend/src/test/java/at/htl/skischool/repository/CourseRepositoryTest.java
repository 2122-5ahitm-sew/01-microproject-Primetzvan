package at.htl.skischool.repository;

import at.htl.entity.Course;
import at.htl.entity.Group;
import at.htl.entity.Skiteacher;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class CourseRepositoryTest {
  @Inject
  public CourseRepository repo;

  @Test
  void addSkiKurs() {
    Skiteacher teacher = new Skiteacher("Hans", "Müller", 55, 1430);
    Course course = new Course("Anfänger20-01-2022", Group.ANFAENGER, teacher);

    repo.save(course);

    long id = course.getId();

    assertThat(repo.findById(id).getName()).isEqualTo(course.getName());

  }


  @Test
  void deleteSkiKurs() {

    Skiteacher teacher = new Skiteacher("Hans", "Müller", 55, 1430);
    Course course = new Course("Anfänger20-01-2022", Group.ANFAENGER, teacher);

    repo.save(course);

    Long id = course.getId();

    repo.delete(id);

    assertThat(repo.findById(id)).isNull();

  }

  @Test
  void findById() {

    Long id;

    Skiteacher teacher = new Skiteacher("Hans", "Müller", 55, 1430);
    Skiteacher teacher1 = new Skiteacher("Hans", "Müller", 55, 1430);
    Skiteacher teacher2 = new Skiteacher("Hans", "Müller", 55, 1430);

    Course course = new Course("Anfänger20-01-2022", Group.ANFAENGER, teacher);
    Course course1 = new Course("Koenner05-01-2021", Group.KOENNER, teacher1);
    Course course2 = new Course("Profi05-01-2021", Group.PROFIS, teacher2);

    repo.save(course);
    repo.save(course1);
    repo.save(course2);


    id = course.getId();

    Course k = repo.findById(id);

    assertThat(k.getId()).isEqualTo(course.getId());

  }

  @Test
  void findAll() {

    Skiteacher teacher = new Skiteacher("Hans", "Müller", 55, 1430);
    Skiteacher teacher1 = new Skiteacher("Hans", "Müller", 55, 1430);
    Skiteacher teacher2 = new Skiteacher("Hans", "Müller", 55, 1430);


    List<Course> list;
    Course course = new Course("Anfänger20-01-2022", Group.ANFAENGER, teacher);
    Course course1 = new Course("Koenner05-01-2021", Group.KOENNER, teacher1);
    Course course2 = new Course("Profi05-01-2021", Group.PROFIS, teacher2);

    repo.save(course);
    repo.save(course1);
    repo.save(course2);

    var listh = repo.findAll();
    list = listh.list();

    assertThat(list.contains(course));
  }

}
