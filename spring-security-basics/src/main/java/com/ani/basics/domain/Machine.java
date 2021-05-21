package com.ani.basics.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class Machine {

    private Long mcId;
    private String name;
    private Boolean isPlc;
}
