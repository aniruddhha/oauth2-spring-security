package com.ani.erp.connector.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ErpData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dtId;

    private String workerId;
    private String machineName;
    private Date productionDate;
    private String departmentId;
}
