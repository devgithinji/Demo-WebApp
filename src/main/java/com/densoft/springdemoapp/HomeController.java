package com.densoft.springdemoapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String showPage() {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user = "dennis";
        String password = "password";

        try {
            System.out.println("connecting to database");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("connection successful");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "main-menu";
    }


}
