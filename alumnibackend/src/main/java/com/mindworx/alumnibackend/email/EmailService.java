package com.mindworx.alumnibackend.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements EmailSender {
    
    //for sending the mail and see logger
    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
    
    @Autowired
    private final JavaMailSender mailSender;
    
    
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    @Override
    @Async
    public void send(String to, String email) {


        //send user an email for confirmation
        try{    
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");
            helper.setText(email, true);
            helper.setTo(to); //send to vaild user email.
            helper.setSubject("Confirm your email");
            helper.setFrom("AlumniApp@Mindworx.co.za");
        }catch (MessagingException e){
            LOGGER.error("failed to send email", e);
            throw new IllegalStateException("failed to send email");
        }
        
    }
}
