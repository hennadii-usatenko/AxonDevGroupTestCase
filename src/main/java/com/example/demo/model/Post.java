package com.example.demo.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_id")
    private int id;

    @Column(name="user_id")
    private int userId;

    @Column(name="create_date")
    private Date date;

    @Column(name="post_title")
    private String title;

    @Column(name="post_body", length = 10_000)
    private String body;

    @Column(name="photo_file_name")
    private String photoFileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable=false, updatable = false)
    private User author;

    @Transient
    private MultipartFile photo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getFormattedDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMMM dd, yyyy", Locale.ENGLISH);
        return dateFormat.format(date);
    }

}
