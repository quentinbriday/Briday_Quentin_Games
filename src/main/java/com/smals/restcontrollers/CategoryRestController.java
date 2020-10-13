package com.smals.restcontrollers;

import com.smals.domain.Category;
import com.smals.domain.Game;
import com.smals.dto.CategoryDto;
import com.smals.services.CategoryServiceImpl;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/categories")
public class CategoryRestController {

    private CategoryServiceImpl categoryService;

    public CategoryRestController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "")
    public List<Category> findAll(){
        return categoryService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Category findById(@PathVariable("id") int id) throws NotFoundException{
        return categoryService.findById(id);
    }

    @PostMapping(path = "")
    public Category save(@RequestBody CategoryDto categoryDto){
        Category category = new ModelMapper().map(categoryDto, Category.class);
        categoryService.save(category);
        return category;
    }

    @PutMapping(path = "")
    public int update(@RequestBody CategoryDto categoryDto){
        Category category = new ModelMapper().map(categoryDto, Category.class);
        categoryService.save(category);
        return category.getId();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable("id") int id) throws NotFoundException {
        categoryService.deleteById(id);
    }
}
