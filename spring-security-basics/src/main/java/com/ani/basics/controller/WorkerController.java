package com.ani.basics.controller;

import org.springframework.web.bind.annotation.*;
import com.ani.basics.domain.Worker;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/worker")
@RestController
public class WorkerController {

    private List<Worker> workers = List.of(
            new Worker(1L,"ani", Date.from(Instant.now()) ),
            new Worker(2L,"qer nm", Date.from(Instant.now()) )
    );

    @GetMapping
    public List<Worker> worker() { return workers; }

    @PostMapping
    public String save(@RequestBody Worker worker) {
        return "worker saved successfully";
    }

    @GetMapping("/delete/{id}")
    public List<Worker> delete(@PathVariable Long id) {
        workers = workers.stream().filter( wk -> !wk.getWkId().equals(id)).collect(Collectors.toList());
        return workers;
    }
}
