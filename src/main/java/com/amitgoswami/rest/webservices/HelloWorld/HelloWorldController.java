package com.amitgoswami.rest.webservices.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    //Create hello-world-bean
    @GetMapping(path ="/hello-world-bean")
    public HelloWorldBean helloWorldBean()
    {
        return new HelloWorldBean("Hello World");
    }

    //Create hello-world/amitgoswami
    @GetMapping(path ="/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
    {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
