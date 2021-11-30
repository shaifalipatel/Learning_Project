package com.example.demo.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Course {
    @OneToMany(mappedBy = "course")
    private final List<Review> reviews = new ArrayList<>();
    /**
     * ManyToMany relationship always contains join table of primary keys
     * of each table
     * toMany---> LazyFetch
     * mappedBy--> didn't own the relationship
     */
    @ManyToMany(mappedBy = "courses")
    private final List<Student> students = new ArrayList<>();
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;

    protected Course() {

    }

    public Course(String name) {
        this.name = name;
    }

    public void addStudents(Student student){
        this.students.add(student);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public  void getReview(int id){
        this.reviews.get(id);
    }
}
