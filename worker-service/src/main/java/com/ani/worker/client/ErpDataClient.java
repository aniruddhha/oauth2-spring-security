package com.ani.worker.client;

import com.ani.worker.domain.ErpDataDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "erp-connector-service")
public interface ErpDataClient {
    @GetMapping("/api/erp/worker/{workerId}")
    ErpDataDto findWorkerByWorkerId(@PathVariable String workerId);

    @PostMapping("/api/erp")
    void save(@RequestBody ErpDataDto dto);
}
