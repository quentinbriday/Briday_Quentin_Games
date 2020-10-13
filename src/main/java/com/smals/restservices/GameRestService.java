package com.smals.restservices;

import com.smals.domain.Game;
import com.smals.services.GameService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("games")
public class GameRestService {

    @Inject
    private GameService gameService;

    @GET
    @Produces("application/json")
    public List<Game> findGames() {
        return gameService.findAllGames();
    }

    @GET
    @Produces("application/json")
    @Path("findByName/{gameName}")
    public Game findGameByName(@PathParam("gameName") String gameName) {
        return gameService.findGameByName(gameName);
    }

    @GET
    @Produces("application/json")
    @Path("findById/{id}")
    public Game findGameById(@PathParam("id") int id) {
        return gameService.findGameById(id);
    }
}
