package com.smals.restservices;

import com.smals.domain.Borrower;
import com.smals.services.BorrowerService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("borrowers")
public class BorrowerRestService {

    @Inject
    private BorrowerService borrowerService;

    @GET
    @Produces("application/json")
    @Path("{id}")
    public Borrower findBorrowerById(@PathParam("id") int id) {
        return borrowerService.findBorrowerById(id);
    }
}
