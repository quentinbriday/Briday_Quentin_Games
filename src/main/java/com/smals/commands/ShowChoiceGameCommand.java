package com.smals.commands;

import com.smals.domain.Game;
import com.smals.services.GameService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShowChoiceGameCommand implements Command {
    @Override
    public void execute() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please, now enter part of the title of the game you're searching");
        System.out.print("Your research --> ");
        String gameName = null;
        try {
            gameName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Game game = new GameService().findGameByName(gameName);
        if (game == null) {
            System.err.println("The game you're searching doesn't exist in our database.");
        } else {
            System.out.println(game.getGameName() + " : \n   publisher : " + game.getEditor()
                    + "\n   age : " + game.getAge()
                    + "\n   price : " + game.getPrice());
        }
    }
}
