package at.htl.skischool.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
public class Course extends PanacheEntity {

  private String name;
  private int member;
  @Enumerated(EnumType.ORDINAL)
  private Group aGroup;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinColumn(name = "Skiteacher_ID")
  private Skiteacher skiteacher;

  public Course() {
  }

  public Course(String name, Group group, Skiteacher skiteacher) {
    this.name = name;
    this.skiteacher = skiteacher;
    this.aGroup = group;
  }

  protected Course(Long id, String name, int member, Group aGroup, Skiteacher skiteacher) {
    this.id = id;
    this.name = name;
    this.member = member;
    this.aGroup = aGroup;
    this.skiteacher = skiteacher;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Group getaGroup() {
    return aGroup;
  }

  public void setaGroup(Group aGroup) {
    this.aGroup = aGroup;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getMember() {
    return member;
  }

  public void setMember(int member) {
    this.member = member;
  }

  public Group getaClass() {
    return aGroup;
  }

  public void setaClass(Group aGroup) {
    this.aGroup = aGroup;
  }

  public Skiteacher getSkiteacher() {
    return skiteacher;
  }

  public void setSkiteacher(Skiteacher skiteacher) {
    this.skiteacher = skiteacher;
  }

  @Override
  public String toString() {
    return "Kurs " +
      "namens " + name +
      ", hat " + member +
      " teilnehmer" +
      "\n";
  }
}
