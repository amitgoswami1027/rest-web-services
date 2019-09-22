package com.amitgoswami.rest.webservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController
{
    //Method - Hello World
    //GET
    //URI -/hello-world
    //method - "Hello World"
    //@RequestMapping(method= RequestMethod.GET, path ="/hello-world");
    @GetMapping(path ="/hello-world")
    public String helloWorld()
    {
        return "Hello World";
    }

}
