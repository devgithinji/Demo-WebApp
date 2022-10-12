package com.densoft.springdemoapp;

import com.densoft.springdemoapp.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
            //create a student object
            Student student = new Student("dennis", "githinji", "wakahiad@gmail.com");

            //start transaction
            session.beginTransaction();

            //save the student
            session.save(student);

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("done");

        } catch (Exception e) {
            System.out.println(e);
            factory.close();
        }

        return "main-menu";
    }


}
