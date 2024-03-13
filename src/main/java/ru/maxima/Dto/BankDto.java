package ru.maxima.Dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;
import ru.maxima.models.Person;

import java.math.BigDecimal;
import java.util.List;

@Data
@JacksonXmlRootElement(localName = "Person")
@Getter
@Setter
public class BankDto {


    private List<Person> result;
    private List<Person> minimum;

}
