package com.example.SpringCloudZipkin1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @GetMapping("/payment")
    public String makePayment() {
        return "Payment successful.";
    }
}




