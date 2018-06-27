package com.example.jerseydata.assembler;

import com.example.jerseydata.dto.PersonDto;
import com.example.jerseydata.mapper.PersonMapper;
import com.example.jerseydata.model.Person;
import com.example.jerseydata.resource.PersonResource;
import org.springframework.stereotype.Component;

@Component
public class PersonAssembler extends JaxRsResourceAssemblerSupport<Person, PersonDto> {

    private final PersonMapper personMapper;

    public PersonAssembler(PersonMapper personMapper) {
        super(PersonResource.class, PersonDto.class);
        this.personMapper = personMapper;
    }

    @Override
    public PersonDto toResource(Person person) {
        PersonDto personDto = createResourceWithId(person.getId(), person);
        PersonDto result = personMapper.toDto(person);
        result.add(personDto.getLinks());
        return result;
    }
}
