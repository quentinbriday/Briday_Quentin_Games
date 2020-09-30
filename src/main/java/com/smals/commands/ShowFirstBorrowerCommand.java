package com.smals.commands;

import com.smals.service.BorrowerService;

import static java.lang.Thread.sleep;

public class ShowFirstBorrowerCommand implements Command {
    @Override
    public void execute() {
        System.out.println(new BorrowerService().findBorrowerById(1));
    }
}
