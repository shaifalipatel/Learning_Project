/*
package com.example.demo.repo.inharitenceHeirarchiesRepo;

import com.example.demo.entity.InharitenceHeirarchies.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager entityManager;

    */
/**
     * Insert data into employee
     *//*

    public void insert(Employee employee){
        entityManager.persist(employee);
    }

    */
/**
     *Read the employee from the Employee table
     *//*


    public List<Employee> getEmployeeList(){
        return entityManager.createQuery("Select e from Employee e ", Employee.class).getResultList();
    }

    public Employee findById(Long id){
        return entityManager.find(Employee.class, id);
    }
}
*/
