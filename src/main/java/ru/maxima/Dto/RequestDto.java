package ru.maxima.Dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Data
@Getter
@Setter
@JacksonXmlRootElement
public class RequestDto {



    private BigDecimal wallet;


    @JacksonXmlProperty(localName = "Person1" , namespace = "person")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<PersonDto> person;
}
