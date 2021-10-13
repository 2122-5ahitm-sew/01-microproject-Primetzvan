package at.htl.skischool.entity;

import at.htl.entity.Skiteacher;
import at.htl.repository.SkiteacherRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class SkiteacherRepositoryTest {

    @Inject
    public SkiteacherRepository repo;

    @Test
    void addSkiTeacher(){

        Skiteacher teacher = new Skiteacher("Hans", "Müller", 55,  1430);

        repo.save(teacher);

      Long id = teacher.getId();

      assertThat(repo.findById(id).getFirstname()).isEqualTo(teacher.getFirstname());

    }

    @Test
    void updateSkiTeacher(){

        Long id;

        Skiteacher teacher = new Skiteacher("Hans", "Müller", 55,  1430);

        repo.save(teacher);

        id = teacher.getId();
        Skiteacher teachernew = new Skiteacher(id, "Hans", "Müller", 60,  1430);

        repo.save(teachernew);

        id = teachernew.getId();


      assertThat(repo.findById(id).getFirstname()).isEqualTo(teachernew.getFirstname());

    }

    @Test
    void deleteSkiTeacher(){

        Skiteacher teacher = new Skiteacher("Hans", "Müller", 55,  1430);

        repo.save(teacher);

        Long id = teacher.getId();

        repo.delete(id);

      assertThat(repo.findById(id)).isNull();
    }

    @Test
    void findAll(){

      PanacheQuery<Skiteacher> list;

        Skiteacher skiteacher = new Skiteacher("Hans", "Müller", 55,  1430);
        Skiteacher skiteacher1 = new Skiteacher("Peter", "Hofer", 50,  1000);
        Skiteacher skiteacher2 = new Skiteacher("Lisa", "Müller", 25,  1000);

        repo.save(skiteacher);
        repo.save(skiteacher1);
        repo.save(skiteacher2);

        list = repo.findAll();

        //assertThat(list).hasSize(3);
        //assertThat(list).contains(skiteacher, skiteacher1, skiteacher2);

    }

    @Test
    void findById(){

        Long id;
        Skiteacher teacher;

        Skiteacher skiteacher = new Skiteacher("Hans", "Müller", 55,  1430);
        Skiteacher skiteacher1 = new Skiteacher("Peter", "Hofer", 50,  1000);
        Skiteacher skiteacher2 = new Skiteacher("Lisa", "Müller", 25,  1000);

        repo.save(skiteacher);
        repo.save(skiteacher1);
        repo.save(skiteacher2);

        id = skiteacher.getId();

        teacher = repo.findById(id);

        assertThat(teacher.getFirstname()).isEqualTo(skiteacher.getFirstname());

    }

}
