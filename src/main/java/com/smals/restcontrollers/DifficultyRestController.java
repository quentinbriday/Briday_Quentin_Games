package com.smals.restcontrollers;

import com.smals.domain.Difficulty;
import com.smals.services.DifficultyServiceImpl;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/difficulties")
public class DifficultyRestController {

    private DifficultyServiceImpl difficultyService;

    public DifficultyRestController(DifficultyServiceImpl difficultyService) {
        this.difficultyService = difficultyService;
    }

    @GetMapping(path = "")
    public List<Difficulty> findAll(){
        return difficultyService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Difficulty findById(@PathVariable("id") int id) throws NotFoundException {
        return difficultyService.findById(id);
    }
}
