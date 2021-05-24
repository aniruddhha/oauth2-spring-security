package com.ani.basics.domain;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Worker {
    private Long wkId;
    private String name;
    private Date lastLogin;
}
