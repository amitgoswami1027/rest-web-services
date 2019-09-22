package com.amitgoswami.rest.webservices.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
public class UserResource
{
    @Autowired
    private UserDAOService service;

    //Get /users
    //retrieveAllUsers
    @GetMapping("/users")
    public List<User> retrieveallUsers(){
        return service.findall();
    }

    // GET /users/{id}
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id)
    {
        User user = service.findOne(id);
        if(user == null)
            throw new UserNotFoundException("id-" + id);
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user)
    {
        User savedUser = service.save(user);

        //return status as CREATED - "201 Created"
        // /user/{id}  savedUser.getId()
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
