package com.mindworx.alumnibackend.model.token;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mindworx.alumnibackend.model.users.Mindworxuser;

@Entity
public class ConfirmationToken {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    private int id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime expiresAt;
 
    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(
        nullable = false,
        name = "alumniapp_user_id"
    )
    private Mindworxuser mindworxuser;


    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt,
             Mindworxuser mindworxuser) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.mindworxuser = mindworxuser;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getexpiresAt() {
        return expiresAt;
    }
    public void setexpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }
    public LocalDateTime getConfirmedAt() {
        return confirmedAt;
    }
    public void setConfirmedAt(LocalDateTime confirmedAt) {
        this.confirmedAt = confirmedAt;
    }


    public Mindworxuser getMindworxuser() {
        return mindworxuser;
    }


    public void setMindworxuser(Mindworxuser mindworxuser) {
        this.mindworxuser = mindworxuser;
    }


    
}
