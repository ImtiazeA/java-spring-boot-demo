# Spring Boot Demo - Hello World
> This demo demonstrates how to write a hello world application using Java, Spring Boot, Gradle.

## Running the Project

### Gradle

```shell
 $ gradlew bootRun
```

## Example Requests
With `name` parameter
```shell
curl http://localhost:8080/demo/hello?name=SpringBootPro
```

Without `name` parameter
```shell
curl http://localhost:8080/demo/hello
```

## Notable Source Files

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

configurations {
    compileOnly {
        extendsFrom annotationProcessor
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    compileOnly 'org.projectlombok:lombok'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

tasks.named('test') {
    useJUnitPlatform()
}

```

### [DemoHelloWorldApplication.java](src/main/java/com/github/imtiazea/helloworld/DemoHelloWorldApplication.java)

```java
@SpringBootApplication
public class DemoHelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoHelloWorldApplication.class, args);
    }

}
```

### [GreetingController.java](src/main/java/com/github/imtiazea/helloworld/GreetingController.java)

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
        String finalName = name == null ? "World!" : name;
        return String.format("Hello, %s!", finalName);
    }

}
```
