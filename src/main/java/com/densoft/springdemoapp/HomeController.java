package com.densoft.springdemoapp;

import com.densoft.springdemoapp.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String showPage() {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //create 3 student objects
            Student student = new Student("paul", "kamau", "paul@gmail.com");
            //start transaction
            session.beginTransaction();

            //save the student
            session.save(student);

            //commit the transaction
            session.getTransaction().commit();

            //get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();
            // retrieve student based on the id: primary key
            System.out.println("Saved student. Generated Id. " + student.getId());
            Student myStudent = session.get(Student.class, student.getId());
            System.out.println("Get complete student: " + myStudent);
            //commit transaction
            session.getTransaction().commit();

            System.out.println("done");

        } catch (Exception e) {
            System.out.println(e);
            factory.close();
        }

        return "main-menu";
    }

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            // retrieve student based on the id: primary key
            System.out.println("Retrieve students");
            //query all students
            List<Student> students = session.createQuery("from Student ").list();


            students = session.createQuery("from Student s where s.lastName = 'doe'").list();

            students = session.createQuery("from Student s where s.lastName = 'doe' or s.firstName = 'test'").list();

            students = session.createQuery("from Student s where s.email LIKE '%nis@gmail.com'").list();

            for (Student student : students) {
                System.out.println(student);
            }

            //commit transaction
            session.getTransaction().commit();

            System.out.println("done");

        } catch (Exception e) {
            System.out.println(e);
            factory.close();
        }

    }


}
