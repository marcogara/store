# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.example.demo-springboot-store' is invalid and this project uses 'com.example.demo_springboot_store' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.3/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.5.3/maven-plugin/build-image.html)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

### Possible TODO

* Create a session timeout mechanism
* Message for invalid credential
* Create a fake user service

* AuthService
* Admin Interface
* Add password hashing (with BCrypt)

* Automatically log the user in after registration

* Add validation (e.g., min length, disallow empty, etc.)

* Add user roles (admin/user)

* Build the admin dashboard