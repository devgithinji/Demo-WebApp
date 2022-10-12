package com.densoft.springdemoapp;

import com.densoft.springdemoapp.entity.Course;
import com.densoft.springdemoapp.entity.Instructor;
import com.densoft.springdemoapp.entity.InstructorDetail;
import com.densoft.springdemoapp.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneRshpDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {

            //start a transaction
            session.beginTransaction();

            //create the objects
//            Instructor instructor = new Instructor("test", "instructor", "test@gmail.com");
//            InstructorDetail instructorDetail = new InstructorDetail("https://www/inst.com", "java guides");


            Instructor instructor = new Instructor("max", "millian", "max@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("https://www/javarecipes.com", "java recipes");
            //associate the objects
            instructor.setInstructorDetail(instructorDetail);


            session.save(instructor);

            //commit transaction
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
            factory.close();
        }
    }
}
