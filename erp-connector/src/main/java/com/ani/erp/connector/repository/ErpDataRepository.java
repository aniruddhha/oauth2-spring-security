package com.ani.erp.connector.repository;

import com.ani.erp.connector.domain.ErpData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ErpDataRepository extends JpaRepository<ErpData, Long> {
    Optional<ErpData> findByWorkerId(String workerId);
}
