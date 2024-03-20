package ru.maxima.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.maxima.Dto.PersonDto;
import ru.maxima.Dto.RequestDto;
import ru.maxima.Dto.ResponseDto;
import ru.maxima.exception.BankNotExceptionHandler;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
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


    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE ,
            path = "/test")
    public ResponseEntity<HttpStatus> jacksonXml(@RequestBody  @Valid RequestDto requestDto, BindingResult result) {
//        Double sum = requestDto.getWallet();
//        for (PersonDto person : requestDto.getPerson()) {
//            sum += person.getWallet();
//        }
//        Double avgSum = sum / requestDto.getPerson().size();
//
//        for (PersonDto person : requestDto.getPerson()) {
//            person.setAppendFromBank(avgSum - person.getWallet());
//        }
//
//        ResponseDto responseDto = new ResponseDto();
//        responseDto.setResult(requestDto.getPerson());
//        responseDto.setMinimum(new ArrayList<>());
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE ,
            path = "/result")
    public ResponseEntity<ResponseDto> getResult(@RequestBody @Valid RequestDto requestDto , BindingResult bindingResult) {



        ResponseDto responseDto = new ResponseDto();


        BigDecimal allMoney = requestDto.getWallet();
        if(requestDto.getPerson() == null ){
            throw new BankNotExceptionHandler("Arr");
        }
        for (PersonDto p : requestDto.getPerson()) {
            allMoney = p.getWallet();
        }
        BigDecimal avgSum;
        avgSum = allMoney.divide(BigDecimal.valueOf(requestDto.getPerson().size()) , 2 , RoundingMode.CEILING);
        for (PersonDto p : requestDto.getPerson()) {
           p.setAppendFromBank(avgSum.subtract(p.getWallet()));
        }


        List<PersonDto> resultPerson = requestDto.getPerson();
        List<PersonDto> minimumPerson = resultPerson.stream().sorted(Comparator
                .comparing(PersonDto:: getAppendFromBank )).toList().subList(0 , 3); // Ошибка здесь !//Ошибка здесь !
        responseDto.setResult(resultPerson);
        responseDto.setMinimum(minimumPerson);
        return ResponseEntity.ok(responseDto);
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
