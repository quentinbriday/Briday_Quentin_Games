package com.smals.commands;

import com.smals.domain.Game;
import com.smals.services.GameService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

public class ShowGameAndChooseCommand implements Command {
    @Override
    public void execute() {
        List<Game> games = new GameService().findAllGames();
        for (Game g : games){
            System.out.println(g.getGameName() + ", category : " + g.getCategory().getCategoryName());
        }
        System.out.println("Now please, enter part of the name of the game you choose : ");
        System.out.print("Your research --> ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String gameName = reader.readLine();
            Optional<Game> optional = games.stream().filter(g -> g.getGameName().toUpperCase().contains(gameName.toUpperCase())).findFirst();
            if (optional.isPresent()){
                System.out.println(optional.get());
            }
            else{
                System.err.println("There is no game with a name matching " + gameName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
