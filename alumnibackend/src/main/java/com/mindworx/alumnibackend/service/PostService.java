/**
 * This class serves to handle any post request and response.
 * This includes flaging, liking and adding comments on a post.
 * also having an actual post
 */
package com.mindworx.alumnibackend.service;


import com.mindworx.alumnibackend.dao.IUserdao;
import com.mindworx.alumnibackend.model.PostComments;
import com.mindworx.alumnibackend.model.PostContent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private IUserdao postDao;
    private PostContent postContent;
    private PostComments  postComments;

    
    
    public PostService(IUserdao postDao, PostContent postContent, PostComments postComments) {
        this.postDao = postDao;
        this.postContent = postContent;
        this.postComments = postComments;
    }



    public PostService() {
    }

    //create methods to handle requests from Post Controller
    
    // //testing - return same post. add it on current session timeline.
    // public List<PostContent>  addPost(PostContent postContent){
    //     //TODO: Find user who posted
    //     //TODO: add to user's list of posted content


    //     //TODO: save new post to database
    //     return listPosts;
    // }
}
