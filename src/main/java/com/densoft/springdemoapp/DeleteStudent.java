package com.densoft.springdemoapp;

import com.densoft.springdemoapp.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            int studentId = 2;

            Student student = session.get(Student.class, studentId);
            //delete the student
            session.delete(student);
            //commit the transaction
            session.getTransaction().commit();

            //another way to delete
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("delete from Student where id = 3").executeUpdate();
            session.getTransaction().commit();


        } catch (Exception e) {
            System.out.println(e);
            factory.close();
        }

    }
}
