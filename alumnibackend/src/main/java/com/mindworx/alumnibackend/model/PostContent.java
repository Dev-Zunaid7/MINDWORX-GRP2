package com.mindworx.alumnibackend.model;

import java.sql.Date;

import org.springframework.http.converter.BufferedImageHttpMessageConverter;

public class PostContent {
    
    
        private String strDiscription;
        private BufferedImageHttpMessageConverter strImage;
        private String strVideo;
        private String strDoc;
        private Date dtPosttimeline;
        private int  likeCounter;
        private int  shareCounter;



        public PostContent(String strDiscription, BufferedImageHttpMessageConverter strImage, String strVideo,
                String strDoc, Date dtPosttimeline, int likeCounter, int shareCounter) {
            this.strDiscription = strDiscription;
            this.strImage = strImage;
            this.strVideo = strVideo;
            this.strDoc = strDoc;
            this.dtPosttimeline = dtPosttimeline;
            this.likeCounter = likeCounter;
            this.shareCounter = shareCounter;
        }

        public PostContent() {
        }

        public String getStrDiscription() {
            return strDiscription;
        }

        public void setStrDiscription(String strDiscription) {
            this.strDiscription = strDiscription;
        }

        public BufferedImageHttpMessageConverter getStrImage() {
            return strImage;
        }

        
        public void setStrImage(BufferedImageHttpMessageConverter strImage) {
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

        public Date getDtPosttimeline() {
            return dtPosttimeline;
        }


        public void setDtPosttimeline(Date dtPosttimeline) {
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

        
    

}
