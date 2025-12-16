package com.deploysense.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    private static final Logger log =
            LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/ok")
    public String ok() {
        log.info("OK endpoint called");
        throw new NullPointerException();
    }

    @GetMapping("/error")
    public String error(@RequestParam(defaultValue = "false") boolean npe) {
        log.error("Error endpoint called");
        if (npe) {
            String s = null;
            s.length(); // ← deterministic NPE for demo
        }
        throw new RuntimeException("Intentional demo error");
    }
}
