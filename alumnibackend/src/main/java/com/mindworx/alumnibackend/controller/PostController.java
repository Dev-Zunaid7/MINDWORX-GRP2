package com.mindworx.alumnibackend.controller;


import java.util.ArrayList;
import java.util.List;

import com.mindworx.alumnibackend.model.PostContent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    List<PostContent> listPosts = new ArrayList<>();
    // only by user
    @GetMapping("/account/home")
    public String feed(Model model) {
        model.addAttribute("postingRequest", new PostContent());
        model.addAttribute("title", "Welcome");
        return  "pages/alumni/feeds";
    }

    //update your post.
    @PostMapping("/account/home/post")
    public String sendPost(Model model, @ModelAttribute PostContent postContent){
        listPosts.add(postContent); //adds the new post on the list of posts from different users.

        //display the new added post on the feeds timeline.
        model.addAttribute("listPosts", listPosts);

        return "pages/alumni/feeds";
    }

    //delete your post.

    //like a post.

}
