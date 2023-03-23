# Task-1-Java-Rest-Api
## Problem Statement
Implement an application in java which provides a REST API with endpoints for searching,
creating and deleting “server” objects:

● GET servers. Should return all the servers if no parameters are passed. When server id
is passed as a parameter - return a single server or 404 if there’s no such a server.

● PUT a server. The server object is passed as a json-encoded message body. Here’s an

example:
{
“name”: ”my centos”,
“id”: “123”,
“language”:”java”,
“framework”:”django”
}

● DELETE a server. The parameter is a server ID.

● GET (find) servers by name. The parameter is a string. Must check if a server name
contains this string and return one or more servers found. Return 404 if nothing is found.
“Server” objects should be stored in MongoDB database.
Be sure that you can show how your application responds to requests using postman, curl or
any other HTTP client.

## We have used SpringBoot Framework to work on the RestApi for task 1 and have used Postman to test the Application
## 1. Api Documentation
For this task, we decided to build a simple api of **Course** Object which has fields such as,

● An Integer Id 

● A String Name

● A String Language

● A String Framework

![image](https://user-images.githubusercontent.com/52740449/227205685-6a43e0bb-1966-4b4f-be3d-5e4308538850.png)

## 2. Build an SpringBoot Application.
Spring Boot is a Java framework for building standalone, production-grade applications that are easy to deploy and manage. It provides a wide range of features and functionalities that make it easy to create web applications and microservices quickly and efficiently.

To create a Spring Boot application, you first need to set up your development environment with Java and a compatible IDE such as Eclipse, IntelliJ IDEA, or NetBeans. Then, you can create a new project using one of the Spring Boot starter templates.

For this task we have used the Spring Tool Suite IDE(STS) to use all the templates and its dependecies.

Let's look at the steps to prepare for task 1.

(i) Download the STS tool

(ii) Use https://start.spring.io/ to dowload all the required template and their dependencies.

(iii) Add Mongodb dependency and the Web Dependency then click on **Generate**

(iv) Open the STS tool and import the downloaded template.

## 2.1 Defining the Controller
In Spring Boot, a controller is a class that handles incoming HTTP requests and sends an HTTP response back to the client. Controllers are responsible for processing user requests, fetching data from the backend services, performing business logic, and returning a response to the client.
Since we are working with rest api, we have to add '@RestController' before the Controller class
The methods in a controller class are mapped to specific HTTP requests using annotations such as @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, etc.

For the Task 1 we would require Get,Post,and Delete Mapping.

### 2.1.1 Prepare the Application to make Api Calls.
Before making any api calls we have to prepare the application, 

● let's first build the Course class. provide it fields such as id, name, framework, and language. create getters and setters method ( since all fields are private ). 

● Create one contorllerService Interface to hold all the necessary methods such as getCourse(), addCourse() and deleteCourse().

● Build one implementation Class that extends this controllerService Interface for loose coupling. Override all the methods.

### 2.1.2 Get all Courses
The Initial state of our application when called with '/courses' must return the list of courses present, therefore to implement this method we would take help of of 2.1.1 to build getCourses() method and override it in the implementation class. In-short it would simply return the List<Course> course object.

Let's test this method, first run the project and then open Postman application select GET request and use url localhost:8080/courses to get all the list of courses

![image](https://user-images.githubusercontent.com/52740449/227213861-c19d2fd9-493b-43cc-89e9-badbfbd2962d.png)

### 2.1.3 Get Particular Course by id

To build this method simply use the '@Pathvarialbe', @PathVariable is an annotation used to extract a variable value from the URI of a request mapping. It is used in conjunction with @RequestMapping or one of its variants, such as @GetMapping, @PostMapping, @PutMapping, or @DeleteMapping.

Therefore pass in @GetMapping {id} variable to use this variable in the method to check for which id is required to display.
Logic is simple just map over each objects in the course list, and check mapped object.id == entered_id or not 

Let's test this method and look at the results,

![courseById](https://user-images.githubusercontent.com/52740449/227215877-83e8f290-64fb-4e32-ac8b-09a9a0b1bd96.png)

We have also made this method capable of handling errors, hence if any unknown id is entered it must return an error. This is done with the help of RequestEntity.

Let's test this example also,

![image](https://user-images.githubusercontent.com/52740449/227216335-26878461-5a2a-47e8-a685-2102b2432d2d.png)

 404 error is returned meaning that entered id doesn't exist in the database.
  
### 2.1.4 Get all Courses with Name.

This method must return all the courses which share the same name, this is done very intelligently using the same method used for getCourseById(), instead of passing a string name, we passed the whole object into {_} and returned a list of courses. As usual this is also made to handle errors. The logic to build this method is also simple simply traverse the course list, check for the name which are equal to the entered name using the .equals string function. If they are equals add it to the new 
list and return this list.
  
Let's look at the results for this method
  
![image](https://user-images.githubusercontent.com/52740449/227217711-fbbe92b9-9dd6-4222-ac5d-7128e6d17ec2.png)

If any unknown name is entered return an error, since the name 'pentoo' doesn't exist in the database.

![image](https://user-images.githubusercontent.com/52740449/227217880-173b30cd-79d3-4674-87a7-62686aefc2b9.png)
  
### 2.1.5 Post Request

Let's build the method to put courses into the database, to build this we need to use the '@PostMapping' annotation before the post method. The logic is very simple simply add this new course to the existing list present and return this list.
  
Let's test this out, make an POST request add a new json object, then simply use the GET request to get all the courses.
  
![image](https://user-images.githubusercontent.com/52740449/227218765-ea3e0cca-e952-463d-8bc5-8decec18c2fa.png)

Let's check whether our newly created object is present in the database or not.
  
![postRequestResult](https://user-images.githubusercontent.com/52740449/227219021-9da57840-aa88-4fb2-b266-a74e04abbe0f.png)


