package at.htl.skischool.repository;

import at.htl.skischool.entity.Skistudent;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class SkistudentRepositoryTest {

    @Inject
    public SkistudentRepository repo;

    @Test
    void addSkiStudent(){

        Skistudent student = new Skistudent("Hans", "Müller", 10);

        repo.save(student);

        Long id = student.getId();

        assertThat(repo.findById(id).getFirstname()).isEqualTo(student.getFirstname());

    }

    @Test
    void updateSkiStudent(){

        Long id;

        Skistudent student = new Skistudent("Hans", "Müller", 10);

        repo.save(student);

        id = student.getId();
        Skistudent studentnew = new Skistudent(id,"Hans", "Müller", 11);

        repo.save(studentnew);

        id = student.getId();

        assertThat(repo.findById(id).getFirstname()).isEqualTo(student.getFirstname());

    }

    @Test
    void deleteSkiStudent(){

        Skistudent student = new Skistudent("Hans", "Müller", 10);

        repo.save(student);

        Long id = student.getId();

        repo.delete(id);

      assertThat(repo.findById(id)).isNull();

    }

    @Test
    void findAll(){

        List<Skistudent> list;

        Skistudent student = new Skistudent("Hans", "Müller", 10);
        Skistudent student1 = new Skistudent("Peter", "Hofer", 50);
        Skistudent student2 = new Skistudent("Lisa", "Müller", 25);

        repo.save(student);
        repo.save(student1);
        repo.save(student2);

        list = repo.findAll().list();

        assertThat(list).hasSize(3);
    }

    @Test
    void findById(){

        Long id;
        Skistudent s;

        Skistudent student = new Skistudent("Hans", "Müller", 10);
        Skistudent student1 = new Skistudent("Peter", "Hofer", 50);
        Skistudent student2 = new Skistudent("Lisa", "Müller", 25);

        repo.save(student);
        repo.save(student1);
        repo.save(student2);

        id = student.getId();

        s = repo.findById(id);

        assertThat(s.getId()).isEqualTo(student.getId());

    }

}
