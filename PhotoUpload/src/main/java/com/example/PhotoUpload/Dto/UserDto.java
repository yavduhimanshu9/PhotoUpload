package com.example.PhotoUpload.Dto;

import org.springframework.web.multipart.MultipartFile;

public class UserDto {
    private String name;
    private String email;
    private MultipartFile photo;

    public UserDto(String name, MultipartFile photo, String email) {
        this.name = name;
        this.photo = photo;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }
}
