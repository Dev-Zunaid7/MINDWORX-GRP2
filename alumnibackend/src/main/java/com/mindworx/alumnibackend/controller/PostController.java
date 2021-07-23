package com.mindworx.alumnibackend.controller;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import com.mindworx.alumnibackend.model.PostContent;
import com.mindworx.alumnibackend.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PostController {

    @Autowired
    public  PostService postService;

    List<PostContent> listPosts = new ArrayList<>();


    public PostController(PostService postService) {
        this.postService = postService;
    }

    // only by user
    @GetMapping("/account/home")
    public String feed(Model model) {
        model.addAttribute("postingRequest", new PostContent());
        model.addAttribute("title", "Welcome");
                //display the new added post on the feeds timeline.
        model.addAttribute("Posts", listPosts );
        return  "pages/alumni/feeds";
    }

    //update your post.
    @PostMapping("/account/home/addpost")
    public String sendPost(Model model, @ModelAttribute("postingRequest") PostContent postContent, @RequestParam("fileImage") MultipartFile  multipartFile) throws IOException{
         //adds the new post on the list of posts from different users.
        //read upload file, if any ( in test- read image)
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        postContent.setStrImage(fileName);
        String postedfilefolder= "./uploadedcontent/" + fileName; //was changed from "./uploadedcontent/" + fileName" means has folder 1231-1313.jpg/1231-1313.jpg

        Path   uploadPath  = Paths.get(postedfilefolder) ;
        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }
        postContent.setUploadedDir(postedfilefolder + fileName);
        System.out.println(postContent.getUploadedDir());

        try {
            InputStream inputStream = multipartFile.getInputStream();
            Path    filePath=   uploadPath.resolve(fileName);
            Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IOException("Could not save uploaded file dude: " + fileName  );
        }

        listPosts.add(postContent);
        return "redirect:/account/home";
    }

    //delete your post.

    //like a post.

}
