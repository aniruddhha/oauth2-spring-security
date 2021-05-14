package com.ani.worker.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RequestMapping("/api/auto")
@RestController
public class AutoRefreshController {

    @Value("${my.key}")
    private String myKey;

    @GetMapping
    public String myKey() {
        return myKey;
    }
}
