package ru.maxima.models;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Data
@JacksonXmlRootElement
@Builder
public class Person {


    private String name;

    @JacksonXmlText
    private BigDecimal wallet;

    private BigDecimal appendFromBank;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getWallet() {
        return wallet;
    }

    public void setWallet(BigDecimal wallet) {
        this.wallet = wallet;
    }

    public BigDecimal getAppendFromBank() {
        return appendFromBank;
    }

    public void setAppendFromBank(BigDecimal appendFromBank) {
        this.appendFromBank = appendFromBank;
    }

    public Person(String name, BigDecimal wallet, BigDecimal appendFromBank) {
        this.name = name;
        this.wallet = wallet;
        this.appendFromBank = appendFromBank;
    }
}
