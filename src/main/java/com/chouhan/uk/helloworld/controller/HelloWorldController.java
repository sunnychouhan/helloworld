package com.chouhan.uk.helloworld.controller;

import com.chouhan.uk.helloworld.model.Sample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@Slf4j
public class HelloWorldController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }

    @PostMapping("/check")
    public Sample checkSample(@RequestBody Sample sample) {
        log.info(" post request  : {}", sample);
        return sample;
    }
}
