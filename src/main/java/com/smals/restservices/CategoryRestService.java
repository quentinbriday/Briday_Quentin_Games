package com.smals.restservices;

import com.smals.domain.Category;
import com.smals.services.CategoryService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("categories")
public class CategoryRestService {

    @Inject
    private CategoryService categoryService;

    @GET
    @Produces("application/json")
    @Path("{id}")
    public Category findById(@PathParam("id") int id) {
        return categoryService.findGameCategoryById(id);
    }
}
