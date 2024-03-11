package ru.maxima.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import ru.maxima.Dto.PersonDto;
import ru.maxima.models.Person;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BankRepositories extends JpaRepository<Person, BigDecimal> {

    List<Person> findByName(String name);
}
