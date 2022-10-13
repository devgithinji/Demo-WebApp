package com.densoft.springdemoapp;

import com.densoft.springdemoapp.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesToStudent {

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
            int studentId  = 5;
            Student student = session.get(Student.class, studentId);


            student.add(new Course("metal works"));
            student.add(new Course("repair"));
            session.save(student);

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
