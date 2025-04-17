package com.example.web;

import com.example.service.TransferService;
import com.example.web.dto.TransferRequest;
import com.example.web.dto.TransferResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TransferController {

    private TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    // GET /transfer
    @RequestMapping(
            value = "/transfer",
            method = RequestMethod.GET
    )
    public String getTransferPage() {
        // Logic to display the transfer page
        return "transfer-form"; // View name for the transfer form
    }

    // POST /transfer
    @RequestMapping(
            value = "/transfer",
            method = RequestMethod.POST
    )
    public String handleTransfer(
           @ModelAttribute TransferRequest transferRequest,
           Model model
    ) {
        transferService.transfer(
                transferRequest.getFromAccount(),
                transferRequest.getToAccount(),
                transferRequest.getAmount()
        );

        TransferResponse transferResponse=new TransferResponse();
        transferResponse.setFromAccount(transferRequest.getFromAccount());
        transferResponse.setToAccount(transferRequest.getToAccount());
        transferResponse.setAmount(transferRequest.getAmount());
        transferResponse.setStatus("Success");
        transferResponse.setTransferId("12345"); // Example transfer ID

        model.addAttribute("transferResponse", transferResponse);

        return "transfer-response"; // View name for the response page
    }

    @ExceptionHandler(
            { IllegalArgumentException.class, IllegalStateException.class }
    )
    public String handleTransferError(
            Exception exception,
            Model model
    ) {
        model.addAttribute("errorMessage", exception.getMessage());
        return "transfer-error"; // View name for the error page
    }

}
