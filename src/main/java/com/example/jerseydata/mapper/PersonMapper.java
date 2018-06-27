package com.example.jerseydata.mapper;

import com.example.jerseydata.dto.PersonDto;
import com.example.jerseydata.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface PersonMapper extends EntityMapper<PersonDto, Person>{

    @Override
    @Mapping(source = "idPerson", target = "id")
    Person toEntity(PersonDto dto);

    @Override
    @Mapping(source = "id", target = "idPerson")
    PersonDto toDto(Person entity);
}
