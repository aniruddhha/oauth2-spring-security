package com.ani.basics.controller;

import com.ani.basics.domain.Machine;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/machine")
@RestController
public class MachineController {

    @GetMapping
    public Machine machine() {
        return new Machine(1L, "sbc", true);
    }

    @PreAuthorize("hasAuthority('machine:on')")
    @PutMapping("/start") // has role machine and has authority to stop
    public String start() {
        return "machine started";
    }

    @PreAuthorize("hasAuthority('machine:off')")
    @PutMapping("/stop") // has role machine and has authority to stop
    public String stop() {
        return "machine stopped";
    }

    @PreAuthorize("hasAnyRole('ROLE_MACHINE', 'ROLE_WORKER_MACHINE')")
    @PutMapping("/pause") // has role (machine or worker) and authority to pause
    public String pause() {
        return "machine paused";
    }
}
