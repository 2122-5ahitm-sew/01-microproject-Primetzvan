package at.htl.skischool.entity;

//import javax.xml.bind.annotation.XmlRootElement;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person extends PanacheEntity {

    private String firstname;
    private String lastname;
    private int age;

    public Person() {
    }

    public Person(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    protected Person(Long id, String firstname, String lastname, int age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
