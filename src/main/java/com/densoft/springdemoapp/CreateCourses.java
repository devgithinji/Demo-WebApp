package com.densoft.springdemoapp;

import com.densoft.springdemoapp.entity.Course;
import com.densoft.springdemoapp.entity.Instructor;
import com.densoft.springdemoapp.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourses {

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

            Instructor instructor = session.get(Instructor.class, id);

            Course tempCourse1 = new Course("Web dev");
            Course tempCourse2 = new Course("Game dev");
            Course tempCourse3 = new Course("Databases");

            instructor.add(tempCourse1);
            instructor.add(tempCourse2);

            session.save(tempCourse1);
            session.save(tempCourse2);

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
