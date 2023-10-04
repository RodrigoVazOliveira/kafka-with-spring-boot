package dev.devaz.rest;


import dev.devaz.data.OrderData;
import dev.devaz.services.EventRegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class OrderRestController {

    private final EventRegisterService eventRegisterService;

    public OrderRestController(EventRegisterService eventRegisterService) {
        this.eventRegisterService = eventRegisterService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    String saveOrder(@RequestBody OrderData orderData) {
        eventRegisterService.addEvent("save_order", orderData);

        return "success";
    }
}
