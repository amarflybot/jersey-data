package com.example.jerseydata.resource;

import com.example.jerseydata.assembler.AddressAssembler;
import com.example.jerseydata.model.Address;
import com.example.jerseydata.repo.AddressRepo;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Component
@Path("/address")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddressResource {

    private final AddressAssembler assembler;

    private final AddressRepo repo;

    public AddressResource(AddressAssembler assembler, AddressRepo repo) {
        this.assembler = assembler;
        this.repo = repo;
    }

    @GET
    public Response getAddresses(){
        List<Address> addresses = repo.findAll();
        return Response.ok(assembler.toResources(addresses)).build();
    }

    @GET
    @Path("/{id}")
    public Response getAddressById(@PathParam("id") Long id) {
        Optional<Address> address = repo.findById(id);
        return Response.ok(assembler.toResource(address.get())).build();
    }
}
