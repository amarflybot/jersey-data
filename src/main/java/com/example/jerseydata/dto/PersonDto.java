package com.example.jerseydata.dto;

import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;

public class PersonDto extends ResourceSupport implements Serializable {

    private Long idPerson;

    private String name;

    private AddressDto address;

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}
