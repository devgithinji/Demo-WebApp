package com.densoft.springdemoapp;

import com.densoft.springdemoapp.entity.Instructor;
import com.densoft.springdemoapp.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetail {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int instructorDetailId = 2;
            //start a transaction
            session.beginTransaction();

            //get instructor
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailId);

            System.out.println("found instructor " + instructorDetail);

            //remove the associated object ref
            instructorDetail.getInstructor().setInstructorDetail(null);

            session.delete(instructorDetail);

            //commit transaction
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
            factory.close();
        }
    }
}
