package com.example.repository;

import com.example.entity.TransferHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransferHistoryRepository extends JpaRepository<TransferHistory,Long> {

    public List<TransferHistory> findByStatus(String status);

}
