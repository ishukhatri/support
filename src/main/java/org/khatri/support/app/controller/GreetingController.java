package org.khatri.support.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    public static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping("/hi")
    public String hello(){
        LOGGER.debug("Pinged Hi Method");
        return "Hi";
    }

    @GetMapping("/exception")
    public String exception(){
        throw new UnsupportedOperationException();
    }
}
