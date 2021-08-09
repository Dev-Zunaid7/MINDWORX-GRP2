package com.mindworx.alumnibackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "post_comments")
public class PostComments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentid")
    private Long commentID;

    @Column(name = "comment")
    private String userComment;

    @ManyToOne
    @JoinColumn(name="postid", nullable=false)
    private PostContent post;

    public PostComments(Long commentID, PostContent post) {
        this.commentID = commentID;
        this.post = post;
    }

    public PostComments() {
    }

    //any user who comments- 
    //retrive their username, then allow to add a comment
    //display in the comment panel

    

}
