Spring Boot Blog Application

Description:- 
This is a Spring Boot application for managing a blog platform. It allows users to create and manage blog posts, comment on posts, categorize posts, and authenticate using JWT (JSON Web Tokens).

Features:- 
1.Blog post creation and management 
2.Commenting on blog posts 
3.Categorization of blog posts 
4.User authentication with login and signup functionality using JWT
5.Exception Handling
6.Security

Installation:-
Make sure you have Java JDK and Maven installed on your machine.
Clone this repository: git clone https://github.com/Taniya1493/springboot-blog-application.git
Navigate to the project directory: cd springboot-blog-application
Build the project using Maven: mvn clean package

Configuration:- 
Configure your database connection in application.properties. Set up the JWT secret key in application.properties.

Usage:- 
1.Run the application: java -jar target/springboot-blog-application.jar 
2.Access the API endpoints to interact with the application.

Endpoints:- 
POST /api/auth/signup: Create a new user account. 
POST /api/auth/login: Authenticate and obtain a JWT token. 
POST /api/posts: Create a new blog post. 
GET /api/posts: Retrieve all blog posts. 
GET /api/posts/{id}: Retrieve a specific blog post by ID. 
POST /api/posts/{id}/comments: Add a comment to a blog post. 
GET /api/categories: Retrieve all post categories.

Authentication:- 
To authenticate, send a POST request to /api/auth/login with username and password. 
Include the obtained JWT token in the Authorization header for subsequent requests: Authorization: Bearer [JWT token].

Sample Requests and Responses:- 
POST /api/auth/signup 
Request: { "username": "user123", "password": "password123" } 
Response: { "message": "User registered successfully." }

Deployment:- 
Deploy the application to a server or cloud platform of your choice.
