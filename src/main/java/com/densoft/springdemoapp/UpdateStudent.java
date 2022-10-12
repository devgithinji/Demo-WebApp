package com.densoft.springdemoapp;

import com.densoft.springdemoapp.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            int studentId = 1;
            //get student
            Student student = session.get(Student.class, studentId);
            student.setFirstName("johnnie");

            //commit transaction
            session.getTransaction().commit();

            //get updated student
            session = factory.getCurrentSession();
            session.beginTransaction();
            Student newStudent = session.get(Student.class, studentId);

            session.getTransaction().commit();
            System.out.println(newStudent);

            session = factory.getCurrentSession();
            session.beginTransaction();

            //update email for all students
            System.out.println("update email for all students");
            session.createQuery("update Student set email = 'foo@gmail.com'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("done");

        } catch (Exception e) {
            System.out.println(e);
            factory.close();
        }

    }
}
