package com.densoft.springdemoapp;

import com.densoft.springdemoapp.entity.Instructor;
import com.densoft.springdemoapp.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BidirectionalOneToOneRshp {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int instructorId = 2;
            //start a transaction
            session.beginTransaction();

            //get instructor
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorId);

            System.out.println("found instructor detail " + instructorDetail);

            System.out.println("instructor " + instructorDetail.getInstructor());

            //commit transaction
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
