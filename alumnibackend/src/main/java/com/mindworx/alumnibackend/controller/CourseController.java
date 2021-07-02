package com.mindworx.alumnibackend.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CourseController {
    

    //display all courses available for subscriber/alumni
    @GetMapping("/account/courses")
    public String getCoursePage(Model model){
        model.addAttribute("title", "Courses");

        return "pages/alumni/courses";
    }

}
