package ru.maxima.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.maxima.Dto.BankDto;
import ru.maxima.exception.BankNotExceptionHandler;
import ru.maxima.models.Bank;
import ru.maxima.models.Person;


import java.math.BigDecimal;
import java.math.RoundingMode;
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


    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<HttpStatus> jacksonXml(@RequestBody  @Valid  Person person , BindingResult result) {

        checkErrors(result);

        person.getName();
        person.getWallet();
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public BankDto getResult(@ModelAttribute("bank") @Valid Bank bank , BindingResult bindingResult) {

        BigDecimal allMoney;
        allMoney = bank.getWallet();
        for (Person p : bank.getPeople()) {
            allMoney = p.getWallet();
        }
        BigDecimal avgSum;
        avgSum = allMoney.divide(BigDecimal.valueOf(bank.getPeople().size()), RoundingMode.CEILING);
        BankDto bankDto = new BankDto();
        List<Person> resultPerson = new ArrayList<>();
        for (Person p : bank.getPeople()) {
            resultPerson.add(Person.builder()
                    .wallet(p.getWallet())
                    .name(p.getName())
                    .appendFromBank(avgSum.subtract(p.getWallet()))
                    .build());
        }

        for (Person a : resultPerson) {
            resultPerson(Person.builder()
                    .wallet(a.getWallet())
                    .name(a.getName())
                    .appendFromBank(a.getWallet().min(avgSum).build()));
//            BigDecimal min =resultPerson
//                    .stream()
//                    .map(a::getName)
//                    .min(a.getWallet().min(avgSum))
//                    .orElse(BigDecimal.ZERO);
        }
        bankDto.setResult(resultPerson);
        bankDto.setMinimum(new ArrayList<>());
        return bankDto;
    }

    public void checkErrors(BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder builder = new StringBuilder();

            List<FieldError> fieldErrors = result.getFieldErrors();
            fieldErrors.forEach(error -> {
                builder.append(error.getField());
                builder.append("-");
                builder.append(error.getDefaultMessage());
            });
            throw new BankNotExceptionHandler(builder.toString());
        }
    }

}
