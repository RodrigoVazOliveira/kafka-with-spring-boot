package dev.devaz.rest;


import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {

    String saveOrder() {
        return "success";
    }
}
