package com.oguzhanserttas.mediumblog.controller;

import com.oguzhanserttas.mediumblog.model.User;
import com.oguzhanserttas.mediumblog.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getById(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> update(@PathVariable("id") Long id,
                                       @RequestBody User entity) {
        if (id == null) {
            throw new RuntimeException("ID is null");
        }
        if (entity == null) {
            throw new RuntimeException("Entity is null");
        }

        if (!id.equals(entity.getId())) {
            throw new RuntimeException("ID is not matched");
        }


        return new ResponseEntity<>(userService.save(entity), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted successfully!", HttpStatus.OK);
    }
}
