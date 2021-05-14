package com.ani.worker.controller;

import com.ani.worker.domain.Worker;
import com.ani.worker.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/worker")
public class WorkerController {

    private final WorkerRepository repository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Worker> findAll() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Worker worker) {
        repository.save(worker);
    }
}
