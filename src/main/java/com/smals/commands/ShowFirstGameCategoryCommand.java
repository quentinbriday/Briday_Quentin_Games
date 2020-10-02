package com.smals.commands;

import com.smals.services.CategoryService;

import static java.lang.Thread.sleep;

public class ShowFirstGameCategoryCommand implements Command {
    @Override
    public void execute() {
        System.out.println(new CategoryService().findGameCategoryById(1));
    }
}
