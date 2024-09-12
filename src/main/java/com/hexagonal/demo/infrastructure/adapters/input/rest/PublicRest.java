package com.hexagonal.demo.infrastructure.adapters.input.rest;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public")
public class PublicRest {

    @Operation(description = "Say hello.")
    public String sayHello() {
        return "Hello from Hexagonal Demo!";
    }
}
