package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private long age;

    @Column(nullable = false)
    private Date dateJoined;

    @Column(nullable = false)
    private Date dateUpdated;

    public Person() {
    }

    public Person(String firstName, String lastName, long age, Date dateJoined, Date dateUpdated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dateJoined = dateJoined;
        this.dateUpdated = dateUpdated;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public long getId() {
        return id;
    }
}
