package com.smals.commands;

import com.smals.domain.Game;
import com.smals.service.GameService;

import java.util.List;

public class ShowAllGamesCommand implements Command {
    @Override
    public void execute() {
        List<Game> games = new GameService().findAllGames();
        for (Game g : games){
            System.out.println(g.getGameName() + " :\n   "
                    + "editor : " + g.getEditor() + "\n   "
                    + "price : " + g.getPrice());
        }
    }
}
