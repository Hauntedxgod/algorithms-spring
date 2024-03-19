package ru.maxima.Dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@JacksonXmlRootElement
public class ResponseDto {

    @JacksonXmlProperty(localName = "total" , namespace = "result")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<PersonDto> result;

    @JacksonXmlProperty(localName = "total2" , namespace = "minimum")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<PersonDto> minimum;
}
