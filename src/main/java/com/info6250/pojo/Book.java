/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.info6250.pojo;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author adityaillur
 */

@Component
@Entity
@Table(name = "BookTable")
@NamedQuery(name="allbooks", query="FROM Book")
public class Book {
    
    @Id
    @GeneratedValue
    @Column(name="ID")
    private int bkid;
    
    @Column(name="ISBN")
    private String bkisbn;
    
    @Basic
    @Column(name="Title")
    private String bktitle;
    
    @Column(name="Author")
    private String bkauth;

    @Transient
    private MultipartFile image;
    
    @Column(name="Image")
    private String imageFilePath;
    
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "USER_ID")
    @Column(name="UserId")
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
     public Book() {
    }

    public Book( String bkisbn, String bktitle, String bkauth) {
        this.bkisbn = bkisbn;
        this.bktitle = bktitle;
        this.bkauth = bkauth;
    }

    public String getBkisbn() {
        return bkisbn;
    }

    public void setBkisbn(String bkisbn) {
        this.bkisbn = bkisbn;
    }

    public String getBktitle() {
        return bktitle;
    }

    public void setBktitle(String bktitle) {
        this.bktitle = bktitle;
    }

    public String getBkauth() {
        return bkauth;
    }

    public void setBkauth(String bkauth) {
        this.bkauth = bkauth;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public int getBkid() {
        return bkid;
    }

    public void setBkid(int bkid) {
        this.bkid = bkid;
    }

    public String getImageFilePath() {
        return imageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }  
    
}
