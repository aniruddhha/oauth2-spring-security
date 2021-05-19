package com.ani.worker.controller;

import com.ani.worker.client.ErpDataClient;
import com.ani.worker.domain.ErpDataDto;
import com.ani.worker.domain.ErpWorkerDto;
import com.ani.worker.domain.Worker;
import com.ani.worker.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/worker")
public class WorkerController {

    private final WorkerRepository repository;
    private final ErpDataClient erpDataClient;
    private final Resilience4JCircuitBreakerFactory circuitBreakerFactory;

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

    @GetMapping(value = "/erp/{wkId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ErpDataDto saveErpWorker(@PathVariable String wkId) {
        var cbf = circuitBreakerFactory.create("erp-connector");
        Supplier<ErpDataDto> supplier = () -> erpDataClient.findWorkerByWorkerId("wk-"+wkId);
        return cbf.run(supplier, throwable -> new ErpDataDto());
    }

    @GetMapping(value = "/erp/save")
    public void saveErpData() {
        final var cbf = circuitBreakerFactory.create("erp-connector");
        final var dto = new ErpDataDto();
        dto.setDtId(System.currentTimeMillis());
        dto.setDepartmentId("dep-"+System.currentTimeMillis());
        dto.setWorkerId("wk-"+System.currentTimeMillis());
        dto.setProductionDate(Date.from(Instant.now()));
        dto.setMachineName("rty");

        Supplier<Void> supplier = () -> {
            erpDataClient.save(dto);
            return null;
        };
        cbf.run(supplier);
    }
}
