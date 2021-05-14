package com.ani.machine.controller;

import com.ani.machine.domain.Machine;
import com.ani.machine.repository.MachineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/machine")
@RequiredArgsConstructor
public class MachineController {

    private final MachineRepository repository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Machine> findAll() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Machine machine) {
        repository.save(machine);
    }
}
