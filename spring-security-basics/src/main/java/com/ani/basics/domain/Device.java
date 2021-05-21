package com.ani.basics.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Device {
    private Long id;
    private String make;
    private Boolean isTelemetry;
}
