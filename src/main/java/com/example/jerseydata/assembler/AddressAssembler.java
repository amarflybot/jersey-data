package com.example.jerseydata.assembler;

import com.example.jerseydata.dto.AddressDto;
import com.example.jerseydata.dto.PersonDto;
import com.example.jerseydata.mapper.AddressMapper;
import com.example.jerseydata.mapper.PersonMapper;
import com.example.jerseydata.model.Address;
import com.example.jerseydata.model.Person;
import com.example.jerseydata.resource.AddressResource;
import com.example.jerseydata.resource.PersonResource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressAssembler extends JaxRsResourceAssemblerSupport<Address, AddressDto> {

    private final AddressMapper addressMapper;

    public AddressAssembler(AddressMapper addressMapper) {
        super(AddressResource.class, AddressDto.class);
        this.addressMapper = addressMapper;
    }

    @Override
    public AddressDto toResource(Address address) {
        AddressDto addressDto = createResourceWithId(address.getId(), address);
        AddressDto result = addressMapper.toDto(address);
        result.add(addressDto.getLinks());
        return result;
    }
}
