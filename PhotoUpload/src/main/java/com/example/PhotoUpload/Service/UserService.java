package com.example.PhotoUpload.Service;

import com.example.PhotoUpload.Dto.UserDto;
import com.example.PhotoUpload.Entity.User;
import com.example.PhotoUpload.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    FileStorageService fileStorageService;

    private static final String PHOTO_URL_BASE = "http://localhost:8080/uploads/";

    public String registerUser(UserDto userDto) {
        String photoFilename = fileStorageService.store(userDto.getPhoto());
        User user = new User(userDto.getName(), userDto.getEmail(), photoFilename);
        userRepository.save(user);
        return generatePhotoUrl(photoFilename);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
    }

    private String generatePhotoUrl(String photoFilename) {
        return PHOTO_URL_BASE + photoFilename;
    }
}
