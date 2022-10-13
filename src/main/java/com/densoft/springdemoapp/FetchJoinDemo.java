package com.densoft.springdemoapp;

import com.densoft.springdemoapp.entity.Course;
import com.densoft.springdemoapp.entity.Instructor;
import com.densoft.springdemoapp.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.getTransaction().begin();

            int id = 1;

            Query<Instructor> query = session.createQuery("SELECT i FROM Instructor i "
                    + "JOIN FETCH i.courses "
                    + "WHERE i.id=:id", Instructor.class);

            //set parameter query
            query.setParameter("id", id);
            //execute query
            Instructor instructor = query.getSingleResult();


            System.out.println("instructor " + instructor);
            System.out.println("courses " + instructor.getCourses());

            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
            factory.close();
        }
    }
}
