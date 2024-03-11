package ru.maxima.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maxima.Dto.PersonDto;
import ru.maxima.models.Person;
import ru.maxima.repositories.BankRepositories;

import java.util.List;

@Service
public class RestService {

    private final BankRepositories repositories;

    private final ModelMapper modelMapper;

    @Autowired
    public RestService(BankRepositories repositories, ModelMapper modelMapper) {
        this.repositories = repositories;
        this.modelMapper = modelMapper;
    }


    public List<Person> getAllPerson(){
        return repositories.findAll();
    }

    public PersonDto convertToPersonDTO(Person person) {
        return modelMapper.map(person , PersonDto.class);
    }
}
