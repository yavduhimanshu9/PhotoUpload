package com.example.PhotoUpload.Controller;

import com.example.PhotoUpload.Dto.UserDto;
import com.example.PhotoUpload.Entity.User;
import com.example.PhotoUpload.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@ModelAttribute UserDto userDto) {
        String photoUrl = userService.registerUser(userDto);
        return ResponseEntity.ok(photoUrl);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }
}