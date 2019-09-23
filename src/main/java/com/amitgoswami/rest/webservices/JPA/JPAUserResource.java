package com.amitgoswami.rest.webservices.JPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class JPAUserResource
{
    @Autowired
    private JPAUserRepository userRepository;

    //Get /users
    //retrieveAllUsers
    @GetMapping("/jpa/users")
    public List<JPAUser> retrieveallUsers()
    {
        return userRepository.findAll();
    }

    // GET /users/{id}
    @GetMapping("/jpa/users/{id}")
    public Resource<JPAUser> retrieveUser(@PathVariable int id)
    {
        Optional<JPAUser> user = userRepository.findById(id);

        if(!user.isPresent())
            throw new JPAUserNotFoundException("id-" + id);

        //"all-users" , SERVER_PATH + "/users"
        //retrievellusers
        //HATEOAS : HYPERMEDIA AS THE ENGINE OF APPLICATION STATE
        Resource<JPAUser> resource = new Resource<JPAUser>(user.get());
        ControllerLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).retrieveallUsers());

        resource.add(linkTo.withRel("all-users"));
        return resource;
    }

    //If user deleted, it will return 200 OK else user not found message
    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id)
    {
        userRepository.deleteById(id);
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody JPAUser user)
    {
        JPAUser savedUser = userRepository.save(user);

        //return status as CREATED - "201 Created"
        // /user/{id}  savedUser.getId()
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
