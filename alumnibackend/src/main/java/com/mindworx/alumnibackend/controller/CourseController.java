package com.mindworx.alumnibackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {
    

    //display all courses available for subscriber/alumni
    @GetMapping("/courses")
    public String getCoursePage(){
        return "pages/imBuildingCourses";
    }

}
