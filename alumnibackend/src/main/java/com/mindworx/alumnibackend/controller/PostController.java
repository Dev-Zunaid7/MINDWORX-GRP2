package com.mindworx.alumnibackend.controller;


import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import com.mindworx.alumnibackend.model.MindworxUserDetails;
import com.mindworx.alumnibackend.model.PostContent;
import com.mindworx.alumnibackend.model.users.Mindworxuser;
import com.mindworx.alumnibackend.model.users.alumni.Alumni;
import com.mindworx.alumnibackend.service.PostService;
import com.mindworx.alumnibackend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    // @Autowired
    // public  PostService postService;
    @Autowired
    private UserService userService; //for security and encapsulation. use postservices

    @Autowired
    private PostService postService;


    // only by user
    @GetMapping("/account/home")
    public String feed(Model model,@AuthenticationPrincipal MindworxUserDetails loggedInUser) {
        model.addAttribute("postingRequest", new PostContent());
        model.addAttribute("title", "Welcome");

        //make sure this converts to a 
        Mindworxuser mindworxuser = userService.getUserbyEmail(loggedInUser.getUsername());
        model.addAttribute("Profile",mindworxuser);

        //display the new added post on the feeds timeline.
        
        return  "pages/alumni/feeds";
    }

    //update your post.
    @PostMapping("/account/home/addpost")
    public ResponseEntity<?> sendPost(Model model, @ModelAttribute("postingRequest") PostContent postContent, @RequestParam("fileImage") MultipartFile  multipartFile, @AuthenticationPrincipal MindworxUserDetails loggedInUser) throws IOException{
         //adds the new post on the list of posts from different users.
      
         //read upload file, if any ( in test- read image)
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        String postedfilefolder= "./uploadedcontent/" + fileName; //was changed from "./uploadedcontent/" + fileName" means has folder 1231-1313.jpg/1231-1313.jpg

        Path   uploadPath  = Paths.get(postedfilefolder) ;
        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }
        //postContent.setUploadedDir(postedfilefolder + fileName);


        try {
            InputStream inputStream = multipartFile.getInputStream();
            Path    filePath=   uploadPath.resolve(fileName);
            Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IOException("Could not save uploaded file dude: " + fileName  );
        }

        Mindworxuser mindworxuser = userService.getUserbyEmail(loggedInUser.getUsername());
        PostContent savedPost = postService.savePost(mindworxuser, postContent.getStrDiscription(), fileName);
        return ResponseEntity.created(URI.create("/private/mypost")).body(savedPost);
    }

    //getting all posst 
    @GetMapping("posts")
    public ResponseEntity<List<PostContent>> getAllPosts(){
        List<PostContent> postList = postService.getAllPost();
        return ResponseEntity.ok(postList);
    }
    //delete your post.

    //like a post.

}
