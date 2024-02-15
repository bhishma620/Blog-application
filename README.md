# Spring Boot Blog Application

# About

This Spring Boot Blog Application is a comprehensive platform designed for efficient management of a blog. Leveraging Spring Boot, Spring Data JPA, and MySQL, it offers a robust backend infrastructure for handling user accounts, posts, categories, comments, and search functionalities via RESTful API.

## Features

- **User Management:** Users can create accounts to access the blog platform.
- **Post Management:** Create, update, delete, and retrieve posts.
- **Category Management:** Organize posts into categories for easy navigation.
- **Commenting System:** Users can interact with posts by leaving comments.
- **Search Functionality:** Search posts by title using keywords.

## Getting Started

To get started with the application, follow these steps:

1. Clone the repository to your local machine:

    ```
    git clone <repository_url>
    ```

2. Navigate to the project directory:

    ```
    cd Blog-application
    ```

3. Configure the database connection settings in `src/main/resources/application.yml`. Update the `url`, `username`, and `password` properties according to your MySQL database configuration.

4. Build the application using Maven:

    ```
    ./mvnw clean package
    ```

5. Run the application:

    ```
    ./mvnw spring-boot:run
    ```

6. Once the application is running, access the API endpoints using a web browser or API testing tool. The base URL is `http://localhost:8081/`.
   
## API Reference

### Users

- **Create User:** `POST /users/`
- **Update User:** `PUT /users/{userId}`
- **Delete User:** `DELETE /users/{userId}`
- **Get All Users:** `GET /users/`
- **Get Single User:** `GET /users/{userId}`

### Posts

- **Create Post:** `POST /user/{userId}/category/{categoryId}/posts`
- **Get Posts by User:** `GET /user/{userId}/posts`
- **Get Posts by Category:** `GET /category/{categoryId}/posts`
- **Get All Posts:** `GET /posts`
- **Get Post by ID:** `GET /posts/{postId}`
- **Delete Post:** `DELETE /posts/{postId}`
- **Update Post:** `PUT /posts/{postId}`
- **Search Posts by Title:** `GET /posts/search/{keywords}`

### Categories

- **Create Category:** `POST /categories/`
- **Update Category:** `PUT /categories/{categoryId}`
- **Delete Category:** `DELETE /categories/{categoryId}`
- **Get Single Category:** `GET /categories/{categoryId}`
- **Get All Categories:** `GET /categories/`

### Comments

- **Create Comment:** `POST /post/{postId}/comments`
- **Delete Comment:** `DELETE /comments/{commentId}`

## Response Format

- `201 Created` for successful user creation.
- `200 OK` for successful user update, retrieval, or retrieval of all users.
- `204 No Content` for successful user deletion.
- `400 Bad Request` if the request is malformed or validation fails.
- `404 Not Found` if the requested user does not exist.

Responses are returned in JSON format following a consistent structure throughout the API. HTTP status codes are utilized to convey the outcome of each request.

## Error Handling

The API handles errors gracefully, providing appropriate HTTP status codes and error messages to aid in troubleshooting and debugging.

---

**Note:** Replace placeholders (e.g., `{userId}`, `{categoryId}`, `{postId}`, `{commentId}`, `{keywords}`) with actual values when making API requests.
