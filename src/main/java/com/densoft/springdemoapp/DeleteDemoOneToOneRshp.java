package com.densoft.springdemoapp;

import com.densoft.springdemoapp.entity.Instructor;
import com.densoft.springdemoapp.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemoOneToOneRshp {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int instructorId = 1;
            //start a transaction
            session.beginTransaction();

            //get instructor
            Instructor instructor = session.get(Instructor.class, instructorId);

            System.out.println("found instructor " + instructor);

            session.delete(instructor);

            //commit transaction
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
            factory.close();
        }
    }
}
