package com.mindworx.alumnibackend.model;

import java.sql.Date;

public class PostContent {
    
    
        private String strDiscription;
        private String strImage;
        private String strVideo;
        private String strDoc;
        private Date dtPosttimeline;

        public PostContent(String strDiscription, String strImage, String strVideo, String strDoc,
                Date dtPosttimeline) {
            this.strDiscription = strDiscription;
            this.strImage = strImage;
            this.strVideo = strVideo;
            this.strDoc = strDoc;
            this.dtPosttimeline = dtPosttimeline;
        }

        public PostContent() {
        }

        public String getStrDiscription() {
            return strDiscription;
        }

        public void setStrDiscription(String strDiscription) {
            this.strDiscription = strDiscription;
        }

        public String getStrImage() {
            return strImage;
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

        public Date getDtPosttimeline() {
            return dtPosttimeline;
        }


        public void setDtPosttimeline(Date dtPosttimeline) {
            this.dtPosttimeline = dtPosttimeline;
        }


    

}
