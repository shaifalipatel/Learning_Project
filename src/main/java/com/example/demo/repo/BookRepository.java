package com.example.demo.repo;

import com.example.demo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class BookRepository {
    /**
     * Used to access the data from the database
     */
    @Autowired
    EntityManager entityManager;

    public Book findById(Long id){
        return entityManager.find(Book.class, id);
    }

    public Book save(Book book){
        if(book.getId()==null){
            entityManager.persist(book);
        }
        else{

        }
        return book;
    }
}
