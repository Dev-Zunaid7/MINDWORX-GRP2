package com.mindworx.alumnibackend.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.google.common.io.Files;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CourseController {
    

    //display all courses available for subscriber/alumni
    @GetMapping("/account/courses")
    public ModelAndView getCoursePage(Model model){
        ModelAndView modelAndView = new ModelAndView("pages/alumni/feeds");
        File input = new File("C:/Users/Lenovo-User/Documents/GitHub/MINDWORX-GRP2/alumnibackend/src/main/resources/templates/pages/alumni/courses.html");

		String pageContent ="";
		try {
			pageContent = Files.asCharSource(input, StandardCharsets.UTF_8).read();
	        // System.out.println(pageContent);
            
            modelAndView.addObject("content",pageContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        modelAndView.addObject("content", pageContent);
        return modelAndView;
    }

}
