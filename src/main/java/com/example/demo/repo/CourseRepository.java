package com.example.demo.repo;

import com.example.demo.entity.Course;
import com.example.demo.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager entityManager;

    public Course findById(Long id){
        return entityManager.find(Course.class, id);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            entityManager.persist(course);
        }
        return course;
    }

    public void addReviewForCourse() {
        /**
         * find course from the database by particular id
         */
        Course course = findById(7l);
        logger.info("Getting the course data "+ course.getId());

        /**
         * add 2 new review
         */
        Review review = new Review("2.0","found it less descriptive");
        Review review2 = new Review("5.0","found it nice");
        logger.info("Review Added");

        course.addReview(review);
        review.setCourse(course);

        course.addReview(review2);
        review2.setCourse(course);

        logger.info("Review Added to the course");

       entityManager.persist(review);
        logger.info("save data");
       entityManager.persist(review2);

        logger.info("Data save successfully");
    }
}
