package com.example.jerseydata.dto;

import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;

public class AddressDto extends ResourceSupport implements Serializable {

    private Long idAddress;

    private String country;

    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
