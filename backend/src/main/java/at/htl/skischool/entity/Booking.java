package at.htl.skischool.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Booking extends PanacheEntity {

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "Skistudent_ID")
    private Skistudent student;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "Course_ID")
    private Course course;

    public Booking(Skistudent student, Course course) {
        this.student = student;
        this.course = course;
    }

    protected Booking(Long id, Skistudent student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Booking() {
    }

    public Skistudent getStudent() {
        return student;
    }

    public void setStudent(Skistudent student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Booking:" +
                "student=" + student.getLastname() +
                ", course=" + course.getName();
    }
}
