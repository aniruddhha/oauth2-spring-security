package com.ani.erp.connector.controller;

import com.ani.erp.connector.domain.ErpData;
import com.ani.erp.connector.repository.ErpDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/erp")
public class ErpDataController {

    private final ErpDataRepository repository;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<ErpData> findAll() {
        return repository.findAll();
    }

    @GetMapping("/worker/{workerId}")
    @ResponseStatus(value = HttpStatus.OK)
    @PreAuthorize("hasRole('erp')")
    public ErpData findMachineByWorkerId(@PathVariable String workerId) {
        return repository.findByWorkerId(workerId).orElseThrow( () -> new RuntimeException("Can Not Find Worker Id -> "+workerId));
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void saveErpData(@RequestBody ErpData data) {
        repository.save(data);
    }
}
