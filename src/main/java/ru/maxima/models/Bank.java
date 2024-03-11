package ru.maxima.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
public class Bank {

    private BigDecimal wallet;

    public Bank() {
    }

    public Bank(BigDecimal wallet) {
        this.wallet = wallet;
    }
}
