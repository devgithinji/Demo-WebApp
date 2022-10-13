package com.densoft.springdemoapp;

import com.densoft.springdemoapp.entity.Course;
import com.densoft.springdemoapp.entity.Instructor;
import com.densoft.springdemoapp.entity.InstructorDetail;
import com.densoft.springdemoapp.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseReviews {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.getTransaction().begin();

            int id = 10;

            Course course = session.get(Course.class, id);

            Review reviewOne = new Review("Good trial");
            Review reviewTwo = new Review("Talented!");

            course.add(reviewOne);
            course.add(reviewTwo);

            session.save(course);

            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
            factory.close();
        }
    }
}
