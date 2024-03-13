package ru.maxima.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.maxima.Dto.BankDto;
import ru.maxima.models.Bank;
import ru.maxima.models.Person;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping( "/bank")
public class BankController {

//    private final RestService service;
//
//    @Autowired
//    public BankController(RestService service) {
//        this.service = service;
//    }


    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public Person jacksonXml(Person person) {
//        List<Person> people = service.getAllPerson();
//        List<BankDto> result = new ArrayList<>();
//        people.forEach(person -> {
//            result.add(service.convertToPersonDTO(person));
//        });
        person.getName();
        person.getWallet();
        return person;
    }

    public BankDto getResult(@ModelAttribute("bank") @Valid Bank bank , BindingResult bindingResult) {
        BigDecimal allMoney = bank.getWallet();
        for (Person p : bank.getPeople()) {
            allMoney = p.getWallet();
        }
        BigDecimal avgSum = allMoney / bank.getPeople().size();
        BankDto bankDto = new BankDto();
        List<Person> resultPerson = new ArrayList<>();
        for (Person p : bank.getPeople()) {
            resultPerson.add(Person.builder()
                    .wallet(p.getWallet())
                    .name(p.getName())
                    .appendFromBank(avgSum - p.getWallet())
                    .build());
        }

        for (Person a : resultPerson) {
            resultPerson(Person.builder()
                    .wallet(a.getWallet())
                    .name(a.getName())
                    .appendFromBank(a.getWallet().min(avgSum).build()));
        }
        bankDto.setResult(resultPerson);
        bankDto.setMinimum(new ArrayList<>());
        return bankDto;
    }

}
