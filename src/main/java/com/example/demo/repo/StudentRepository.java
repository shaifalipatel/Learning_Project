package com.example.demo.repo;

import com.example.demo.entity.Passport;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
/**
 * @Transactional
 * Either all the changes gets completed/
 * all fails for a particular method
 * @Transactional contains PERSISTENCE CONTEXT
 * After every query data will be save in PERSISTENCE CONTEXT
 */
@Transactional
public class StudentRepository {

    /**
     * Entity Manager is used for access the data from the database
     */
    @Autowired
    EntityManager entityManager;

    public Student findById(Long id){
        return entityManager.find(Student.class, id);
    }

    public Student save(Student student) {
        if (student.getId() == null) {
            entityManager.persist(student);
        }
        return student;
    }

    public void saveStudentWithPassport(){
        Passport passport = new Passport("1234ghr");
        entityManager.persist(passport);
        Student student = new Student("AMAN");
        student.setPassport(passport);
        entityManager.persist(student);
    }
}
