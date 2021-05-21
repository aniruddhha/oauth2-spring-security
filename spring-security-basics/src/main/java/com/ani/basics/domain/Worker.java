package com.ani.basics.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@AllArgsConstructor
@Getter
@Setter
public class Worker {
    private Long wkId;
    private String name;
    private Date lastLogin;
}
