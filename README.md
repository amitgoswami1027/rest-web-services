# REST WEBSERVICES
MicroServices with Spring Boot &amp; Spring Cloud

#MICROSERVICES

A.	INTRODUCTION
Web Service – W3C Definition – Software system designed to support interoperable machine to machine interaction over a network.  
Developing RESTful web services is fun. The combination of Spring Boot, Spring Web MVC, Spring Web Services and JPA makes it even more fun. It’s fun to create Microservices.

There are two parts to it - RESTful web services and Microservices
Architectures are moving towards MicroServices.
RESTful web services are the first step to developing great microservices. Spring Boot, in combination with Spring Web MVC (also called Spring REST) makes it easy to develop RESTful web services.

##WEB SERVICES GROUPS – SOAP base and RESTFUL style.

SOAP: (Simple Object Access Protocol)
Service Definition: WSDL – Web Services Definition Language. 
•	Endpoint
•	All Operations
•	Request Structure 
•	Response Structure

REST: (Representational State Transfer)
•	Make use of HTTP – GET,POST,PUT ; Status Codes to create REST Services.
•	Think in term of Resources. 
•	URI to a resource. /user/amit/todos/1 ; /user/amit/todos
•	Data Exchange Formats: XML/JSON/HTML
•	Service Defination : WADL/Swagger

B.	REST WEBSERVICES USING SPRING BOOT
Use the below resources to create the initial application dependencies:
•	http://start.spring.io
•	Intellj “Spring Assistant”

Restful Web Services
•	Retrieve all Users - GET /users
•	Create a User - POST /users
•	Retrieve on User – GET /user{id} -> /users/1 
•	Delete a User – DELETE  /user/{id}/posts -> /users/1

Social Media Application
User  Post
•	Retrieve all posts for a User – GET /users/{id}/posts
•	Create a posts for a User – POST /users/{id}/posts
•	Retrieve details of a post – GET /users/{id}/posts/{post_id}

What is dispatcher servlet? Front controller for spring web container. 

##HATEOAS – HYPERMEDIA AS THE ENGINE OF APPLICATION STATE

##INTERNATIONALIZATION 

####Internationalization 
### Configuration
-	Default Locale – Locale.US
-	ResourceBundleMessageSource.
-	























