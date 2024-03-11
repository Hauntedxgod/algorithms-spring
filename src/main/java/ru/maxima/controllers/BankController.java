package ru.maxima.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.maxima.Dto.PersonDto;
import ru.maxima.models.Person;
import ru.maxima.service.RestService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/bank",
        produces = "templates/bank")
public class BankController {

    private final RestService service;

    @Autowired
    public BankController(RestService service) {
        this.service = service;
    }


    @ResponseBody
    @GetMapping()
    public List<PersonDto> jacksonXml() {

        List<Person> people = service.getAllPerson();
        List<PersonDto> result = new ArrayList<>();
        people.forEach(person -> {
            result.add(service.convertToPersonDTO(person));
        });
        return result;
    }

}
