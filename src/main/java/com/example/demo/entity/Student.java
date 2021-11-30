package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    /**
     * Mapping between student and passport table
     * by default egerFetch
     * toOne---->have egerFetch
     */
    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;

    /**
     * jointable name and column name will be written on the owning side of the entity
     * @JoinTable = have the joining table name
     * @joinColumns = have the join column name
     * @inverseJoinColumn = used for another column for another entity which is mapped
     */
    @ManyToMany
    @JoinTable(name = "Student_Course",
            joinColumns = @JoinColumn(name = "Student_id"),
            inverseJoinColumns = @JoinColumn(name = "Course_id")
    )
    private List<Course> courses = new ArrayList<>();

    protected Student() {

    }

    public Student(String name) {
        this.name = name;
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
