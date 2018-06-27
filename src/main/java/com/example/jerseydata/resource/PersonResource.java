package com.example.jerseydata.resource;

import com.example.jerseydata.assembler.PersonAssembler;
import com.example.jerseydata.model.Person;
import com.example.jerseydata.repo.PersonRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    private final PersonAssembler assembler;

    private final PersonRepo repo;

    public PersonResource(PersonAssembler assembler, PersonRepo repo) {
        this.assembler = assembler;
        this.repo = repo;
    }

    @GET
    public Response getAddresses(
            @QueryParam("page") @DefaultValue("0") Integer page,
            @QueryParam("size") @DefaultValue("3") Integer size,
            @QueryParam("sort") List<String> sort){
        List<Sort.Order> orders = new ArrayList<>();
        for (String propOrder: sort) {
            String[] propOrderSplit = propOrder.split(",");
            String property = propOrderSplit[0];
            if (propOrderSplit.length == 1) {
                orders.add(Sort.Order.by(property));
            } else {
                Sort.Direction direction
                        = Sort.Direction.fromOptionalString(propOrderSplit[1]).get();
                orders.add(new Sort.Order(direction, property));
            }
        }

        Pageable pageable = PageRequest.of(page, size,
                orders.isEmpty() ? null : Sort.by(orders));

        List<Person> people = repo.findAll(pageable).getContent();
        return Response.ok(assembler.toResources(people)).build();
    }

    @GET
    @Path("/{id}")
    public Response getAddressById(@PathParam("id") Long id) {
        Optional<Person> person = repo.findById(id);
        return Response.ok(assembler.toResource(person.get())).build();
    }
}
