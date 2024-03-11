package ru.maxima.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maxima.Dto.PersonDto;

import java.math.BigDecimal;

@RestController
public class BankController {



    @GetMapping(value = "/api/jackson-xml", produces = "templates/bank")
    public PersonDto jacksonXml() {
        BigDecimal decimal = new BigDecimal("1.34");
        return new PersonDto("Михаил", decimal);
    }

}
