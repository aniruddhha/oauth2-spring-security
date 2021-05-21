package com.ani.basics.controller;

import com.ani.basics.domain.Worker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;

@RequestMapping("/api/worker")
@RestController
public class WorkerController {

    @GetMapping
    public Worker worker() {
        return new Worker(2L, "ani", Date.from(Instant.now()));
    }
}
