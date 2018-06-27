package com.example.jerseydata.config;

import com.example.jerseydata.resource.AddressResource;
import com.example.jerseydata.resource.PersonResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(PersonResource.class);
        register(AddressResource.class);
    }
}
