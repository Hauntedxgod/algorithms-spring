package ru.maxima.Dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PersonDto {

    private String name;

    private BigDecimal wallet;

    public PersonDto() {
    }

    public PersonDto(String name, BigDecimal wallet) {
        this.name = name;
        this.wallet = wallet;
    }
}
