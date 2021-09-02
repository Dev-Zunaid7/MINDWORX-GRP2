package com.mindworx.alumnibackend.model;


import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import com.mindworx.alumnibackend.model.users.Mindworxuser;

@Entity
@Table(name = "user_posts")
public class PostContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postid")
    private Long id;

    @Column(name="postDescrip", nullable = false)
    private String strDiscription;

    @Column(name = "postImg", nullable = true)
    private String strImage;
    @Column(name = "postVideo", nullable = true)
    private String strVideo;
    @Column(name = "postDoc", nullable = true)
    private String strDoc;
    @Column(name = "postdate")
    private LocalDateTime dtPosttimeline;
    @Column(name = "postlikes", columnDefinition = "integer default 0")
    private int likeCounter;
    @Column(name = "postshares", columnDefinition = "integer default 0")
    private int shareCounter;
    @Column(name = "postcomments", columnDefinition = "integer default 0")
    private int commentCounter;

    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private Mindworxuser user;

    @OneToMany(mappedBy = "post")
    private Set<PostComments> postComments;

    public PostContent(String strDiscription, String strImage, String strVideo, String strDoc,
    LocalDateTime dtPosttimeline, int likeCounter, int shareCounter, int commentCounter) {
        this.strDiscription = strDiscription;
        this.strImage = strImage;
        this.strVideo = strVideo;
        this.strDoc = strDoc;
        this.dtPosttimeline = dtPosttimeline;
        this.likeCounter = likeCounter;
        this.shareCounter = shareCounter;
        this.commentCounter = commentCounter;
    }

    public PostContent() {
    }

    public String getStrDiscription() {
        return strDiscription;
    }

    public void setStrDiscription(String strDiscription) {
        this.strDiscription = strDiscription;
    }

    @Transient
    public String getPostImagePath() {
        
        if(strImage == null) return null;
        return "/userprofileImg/" + strImage + "/" + strImage;
    }
    public void setStrImage(String strImage) {
        this.strImage = strImage;
    }

    public String getStrVideo() {
        return strVideo;
    }

    public void setStrVideo(String strVideo) {
        this.strVideo = strVideo;
    }

    public String getStrDoc() {
        return strDoc;
    }

    public void setStrDoc(String strDoc) {
        this.strDoc = strDoc;
    }

    public LocalDateTime getDtPosttimeline() {
        return dtPosttimeline;
    }

    public void setDtPosttimeline(LocalDateTime dtPosttimeline) {
        this.dtPosttimeline = dtPosttimeline;
    }

    public int getLikeCounter() {
        return likeCounter;
    }

    public void setLikeCounter(int likeCounter) {
        this.likeCounter = likeCounter;
    }

    public int getShareCounter() {
        return shareCounter;
    }

    public void setShareCounter(int shareCounter) {
        this.shareCounter = shareCounter;
    }

    public int getCommentCounter() {
        return commentCounter;
    }

    public void setCommentCounter(int commentCounter) {
        this.commentCounter = commentCounter;
    }

    public Mindworxuser getMindworxuser() {
        //TODO: return all the posts of a user in list.
        return user;
    }

    public void setMindworxuser(Mindworxuser mindworxuser) {
        //TODO: some updates to how a post is added and linked to its user.
        this.user = mindworxuser;
    }
    

    public Set<PostComments> getPostComments() {
        //TODO: logical statements to handle the return list of comments made on a given post
        return postComments;
    }

    public void setPostComments(Set<PostComments> postComments) {
        //TODO: Logical statements to handle the... instructions still pending/brainstorming.
        this.postComments = postComments;
    }

    public Long getPostID() {
        return id;
    }
    


}
