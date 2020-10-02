package com.smals.commands;

import com.smals.services.GameService;

import static java.lang.Thread.sleep;

public class ShowFifthGameCommand implements Command {
    @Override
    public void execute() {
        System.out.println(new GameService().findGameById(5));
    }
}
