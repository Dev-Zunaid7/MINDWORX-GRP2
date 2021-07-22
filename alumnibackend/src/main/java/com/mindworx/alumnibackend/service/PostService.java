/**
 * This class serves to handle any post request and response.
 * This includes flaging, liking and adding comments on a post.
 * also having an actual post
 */
package com.mindworx.alumnibackend.service;


import java.util.ArrayList;
import java.util.List;

import com.mindworx.alumnibackend.model.PostContent;

import org.springframework.stereotype.Service;

@Service
public class PostService {

    public PostService() {
    }
    //create methods to handle requests from Post Controller
    
    //testing - return same post. add it on current session timeline.
    public List<PostContent>  addPost(PostContent postContent){
        //TODO: Find user who posted
        //TODO: add to user's list of posted content
        List<PostContent> listPosts = new ArrayList<>();

        listPosts.add(postContent);
        //TODO: save new post to database
        return listPosts;
    }
}
