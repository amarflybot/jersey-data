package com.example.jerseydata.mapper;

import com.example.jerseydata.dto.AddressDto;
import com.example.jerseydata.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper extends EntityMapper<AddressDto, Address>{

    @Override
    @Mapping(source = "idAddress", target = "id")
    Address toEntity(AddressDto dto);

    @Override
    @Mapping(source = "id", target = "idAddress")
    AddressDto toDto(Address entity);
}
