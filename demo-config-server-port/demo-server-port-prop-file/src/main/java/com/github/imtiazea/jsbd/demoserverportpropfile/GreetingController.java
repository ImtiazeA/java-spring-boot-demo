package com.github.imtiazea.jsbd.demoserverportpropfile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
