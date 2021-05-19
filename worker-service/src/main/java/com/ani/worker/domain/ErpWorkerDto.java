package com.ani.worker.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErpWorkerDto {
    private Worker worker;
    private ErpDataDto erp;
}
