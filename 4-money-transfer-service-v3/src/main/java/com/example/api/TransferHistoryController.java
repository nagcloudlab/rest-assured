package com.example.api;


import com.example.entity.TransferHistory;
import com.example.repository.TransferHistoryRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "TransferHistory", description = "Endpoints for transfer history")
@RestController
@RequestMapping("/api/transfer-history")
public class TransferHistoryController {

    private final TransferHistoryRepository transferHistoryRepository;

    public TransferHistoryController(TransferHistoryRepository transferHistoryRepository) {
        this.transferHistoryRepository = transferHistoryRepository;
    }

    @GetMapping
    public ResponseEntity<?> getTransferHistory() {
        List<TransferHistory> transferHistoryList= transferHistoryRepository.findAll();
        if (transferHistoryList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(transferHistoryList);
    }

    // to filter resources , use query params
    // GET /api/transfer-history?status=success
    @GetMapping(params = "status")
    public ResponseEntity<?> getTransferHistoryByStatus(String status) {
        List<TransferHistory> transferHistoryList = transferHistoryRepository.findByStatus(status);
        if (transferHistoryList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(transferHistoryList);
    }


}
