# Spring Boot Demo - Configure Server Port - Programmatically with Java with Environment Variable

This is a demo project using Java, Spring Boot, Gradle. This demo demonstrates how to programmatically specify port
instead of running the web server on the default port no 8080.

### Change the HTTP Port

> In a standalone application, the main HTTP port defaults to 8080 but can be set with server.port (for example, in
> application.properties or as a System property).

### Use a Random Unassigned HTTP Port

> To scan for a free port use server.port=0.

In this project, the port is set to 8090.

## Running the Project

### Gradle

```shell
 $ gradlew bootRun
```

## Example Requests

With `name` parameter

```shell
curl http://localhost:8090/demo/hello?name=SpringBootPro
```

Without `name` parameter

```shell
curl http://localhost:8090/demo/hello
```

## Notable Source Files

### application.yml

```yaml
server:
  servlet:
    context-path: /demo
```

### [build.gradle](build.gradle)

```groovy
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.2.1'
    id 'io.spring.dependency-management' version '1.1.4'
}

group = 'com.github.imtiazea.jsbd'
version = '0.0.1-SNAPSHOT'

java {
    sourceCompatibility = '21'
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

tasks.named('test') {
    useJUnitPlatform()
}
```

### [DemoServerPortJavaEnvApplication.java](src/main/java/com/github/imtiazea/jsbd/demoserverportjavaenv/DemoServerPortJavaEnvApplication.java)

```java
@SpringBootApplication
public class DemoServerPortJavaEnvApplication {

    public static void main(String[] args) {
        System.setProperty("server.port", "8090");
        SpringApplication.run(DemoServerPortJavaEnvApplication.class, args);
    }

}
```

### [GreetingController.java](src/main/java/com/github/imtiazea/jsbd/demoserverportjavaenv/GreetingController.java)

```java

@RestController
public class GreetingController {

    /**
     * Returns a greeting message with the given name.
     *
     * @param name the name to be included in the greeting message (optional)
     * @return a greeting message as "Hello, ${name}
     */
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", required = false) String name) {
        String finalName = name == null ? "World" : name;
        return String.format("Hello, %s!", finalName);
    }

}
```
