package com.ani.worker.domain;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErpDataDto {
    private Long dtId;
    private String workerId;
    private String machineName;
    private Date productionDate;
    private String departmentId;
}
