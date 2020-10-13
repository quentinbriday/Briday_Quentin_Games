package com.smals.restcontrollers;

import com.smals.domain.Game;
import com.smals.dto.GameDto;
import com.smals.services.GameServiceImpl;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/games")
public class GameRestController {

    private GameServiceImpl gameService;

    public GameRestController(GameServiceImpl gameService) {
        this.gameService = gameService;
    }

    @GetMapping(path = "")
    public List<Game> findAll(){
        return gameService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Game findById(@PathVariable("id") int id) throws NotFoundException{
        return gameService.findById(id);
    }

    @PostMapping(path = "")
    public Game save(@RequestBody GameDto gameDto){
        Game game = new ModelMapper().map(gameDto, Game.class);
        gameService.save(game);
        return game;
    }

    @PutMapping(path = "")
    public int update(@RequestBody GameDto gameDto){
        Game game = new ModelMapper().map(gameDto, Game.class);
        gameService.save(game);
        return game.getId();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable("id") int id) throws NotFoundException{
        gameService.deleteById(id);
    }
}
