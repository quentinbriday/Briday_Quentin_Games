package com.smals.restservices;

import com.smals.domain.Borrow;
import com.smals.services.BorrowService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import java.util.List;

@Path("borrows")
public class BorrowRestService {

    @Inject
    private BorrowService borrowService;

    @GET
    @Produces("application/json")
    public GenericEntity<List<Borrow>> findAllBorrows() {
        //Without this casting, the application has trouble ton serialize/deserialize the List of Borrow
        return new GenericEntity<List<Borrow>>(borrowService.findAllBorrow()) {
        };
    }
}
