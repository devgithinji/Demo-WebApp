package com.densoft.springdemoapp;

import com.densoft.springdemoapp.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesForStudent {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.getTransaction().begin();
            Course course = new Course("plant operation");

            Student student = new Student("albert", "njoroge", "albert@gmail.com");
            Student student1 = new Student("fiona", "wambui", "fiona@gmail.com");

            course.addStudent(student);
            course.addStudent(student1);

            session.save(course);

            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
