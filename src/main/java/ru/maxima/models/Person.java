package ru.maxima.models;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
@JacksonXmlRootElement
public class Person {


    private String name;

    @JacksonXmlText
    private BigDecimal wallet;

    public Person(String name, BigDecimal wallet) {
        this.name = name;
        this.wallet = wallet;
    }
}
