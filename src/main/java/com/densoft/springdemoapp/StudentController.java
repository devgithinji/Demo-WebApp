package com.densoft.springdemoapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{countryOptions}")
    private LinkedHashMap<String, String> countryOptions;


    @RequestMapping("/showForm")
    public String showForm(Model theModel) {
        Student student = new Student();
        theModel.addAttribute("student", student);
        // add the country options to the model
        theModel.addAttribute("theCountryOptions", countryOptions);
        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student theStudent, Model theModel) {
        theModel.addAttribute("student", theStudent);
        return "student-confirmation";
    }
}
