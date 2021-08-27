/**
 * This class serves to handle any post request and response.
 * This includes flaging, liking and adding comments on a post.
 * also having an actual post
 */
package com.mindworx.alumnibackend.service;


import java.time.LocalDateTime;
import java.util.List;

import com.mindworx.alumnibackend.dao.IPostdao;
import com.mindworx.alumnibackend.model.PostComments;
import com.mindworx.alumnibackend.model.PostContent;
import com.mindworx.alumnibackend.model.users.Mindworxuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class PostService {

    private IPostdao  iPostdao;

    // @Autowired
    // private PostComments  postComments;


    private ModelMap modelMap;

    


    @Autowired
    public PostService( IPostdao iPostdao, ModelMap modelMap) {
        this.iPostdao = iPostdao;
        this.modelMap = modelMap;
    }

    public PostService() {
    }

    //create methods to handle requests from Post Controller
    
    public PostContent savePost(Mindworxuser mindworxuser, String content, String photo){
        PostContent post = new PostContent();
        Mindworxuser user = mindworxuser;
        post.setMindworxuser(user);
        post.setStrDiscription(content);
        post.setDtPosttimeline(LocalDateTime.now());
        post.setStrImage(photo);
        post.setStrVideo(null);
        return iPostdao.save(post);
    }

    //getting posts of a specific user.
    // public List<PostDto> getPostsOfUser(Integer userId){
    //     List<Post> postList= postRepository.findPostByUserOrderById(userRepository.findUserById(userId));
    //     List<PostDto> postDtoList= new ArrayList<>();
    //     for (Post post :postList) {
    //         postDtoList.add(modelMapper.map(post,PostDto.class));
    //     }
    //     return postDtoList;
    // }


    //returning all posts.
    public List<PostContent> getAllPost(){
        return iPostdao.findAllByOrderByIdDesc();
    }
}
 