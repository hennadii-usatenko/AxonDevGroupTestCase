# Task Condition
Create a Restful API which will be used by the simple blog web application.
The application should have one user role - **PUBLISHER**.

REST resources to implement:
- Resource to authenticate a particular user. Users may be hardcoded.
- Create, update, delete own blog posts.
- Get the list of all blog posts. Filter option to get only own posts should be present.
- Get a particular blog post by id.
The **publisher** should be able to update or remove only own posts. All REST resources must be secure except the authentication one.

Short readme with instructions how to build and run application should be present.
API documentation or curl requests are appreciated.

Required technologies: Java 8 and any desired DB's and frameworks.
# How to run app
1. mvn clean
2. mvn clean install
3. Go to the target folder
4. java -jar demo-0.0.1-SNAPSHOT.ja
- http://localhost:8080/registration
- http://localhost:8080/login

# Overview
**To authenticate we have several ways:**
- Sign up new account http://localhost:8080/registration and login http://localhost:8080/login to our web app with role - **PUBLISHER**

![alt text](https://github.com/GennadiyUsatenko/AxonDevGroupTestCase/blob/master/src/main/webapp/WEB-INF/images/777.gif)

- Just login by one from two hardcoded users (email and password the same: **root-root** or **user-user**)
- Enter as guest http://localhost:8080/local/home

**Create own blog post:**

![alt text](https://github.com/GennadiyUsatenko/AxonDevGroupTestCase/blob/master/src/main/webapp/WEB-INF/images/777.gif)

**Update own blog post:**

![alt text](https://github.com/GennadiyUsatenko/AxonDevGroupTestCase/blob/master/src/main/webapp/WEB-INF/images/777.gif)

**Delete own blog post:**

![alt text](https://github.com/GennadiyUsatenko/AxonDevGroupTestCase/blob/master/src/main/webapp/WEB-INF/images/777.gif)

**Get the list of all blog posts:**

![alt text](https://github.com/GennadiyUsatenko/AxonDevGroupTestCase/blob/master/src/main/webapp/WEB-INF/images/777.gif)

**Get only own posts:**

![alt text](https://github.com/GennadiyUsatenko/AxonDevGroupTestCase/blob/master/src/main/webapp/WEB-INF/images/777.gif)

**Get a particular blog post:**

![alt text](https://github.com/GennadiyUsatenko/AxonDevGroupTestCase/blob/master/src/main/webapp/WEB-INF/images/777.gif)

# API Documentation
## Create blog post
Saves particular post to db. And redirects to post page.
* **URL**

  /admin/create/post
* **Method:**

  `POST`
* **URL Params**

  None
  
* **Data Params**

  Post.class
* **Success Response:**

  * **Code:** 302 <br />
    **Content:** `redirect:/local/post/ + post.getId()`
    
* **Sample Call:**

  ```javascript
    <form th:action="@{/admin/create/post}"
          th:object="${post}" method="post" enctype="multipart/form-data">
    </form>
  ```
## Update blog post
Updates particular post. And redirects to post page.
* **URL**

  /admin/update/post
* **Method:**

  `POST`
* **URL Params**

  None
  
* **Data Params**

  Post.class
* **Success Response:**

  * **Code:** 302 <br />
    **Content:** `redirect:/local/post/ + post.getId()`
    
* **Sample Call:**

  ```javascript
    <form th:action="@{/admin/update/post}"
          th:object="${post}" method="post" enctype="multipart/form-data">
    </form>
  ```
## Delete blog post
Delete particular post from db. And redirects to home page.
* **URL**

  /admin/delete/post/:id
* **Method:**

  `GET`
*  **URL Params**

   **Required:**
 
   `id=[integer]`
  
* **Data Params**

  None
* **Success Response:**

  * **Code:** 302 <br />
    **Content:** `redirect:/local/home/`
    
* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/admin/delete/post/1",
      dataType: "json",
      type : "GET",
      success : function(r) {
        console.log(r);
      }
    });
  ```
  
  # The css template is taken from:
  
    https://colorlib.com/wp/template/webmag/
  # The spring template is taken from:
  
    https://github.com/gustavoponce7/SpringSecurityUserDetailsService
