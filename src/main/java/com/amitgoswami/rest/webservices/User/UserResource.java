package com.amitgoswami.rest.webservices.User;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.validation.Valid;
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
    public Resource<User> retrieveUser(@PathVariable int id)
    {
        User user = service.findOne(id);
        if(user == null)
            throw new UserNotFoundException("id-" + id);

        //"all-users" , SERVER_PATH + "/users"
        //retrievellusers
        //HATEOAS : HYPERMEDIA AS THE ENGINE OF APPLICATION STATE
        Resource<User> resource = new Resource<User>(user);
        ControllerLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).retrieveallUsers());

        resource.add(linkTo.withRel("all-users"));
        return resource;
    }

    //If user deleted, it will return 200 OK else user not found message
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id)
    {
        User user = service.deleteById(id);
        if(user == null)
            throw new UserNotFoundException("id-" + id);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user)
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
