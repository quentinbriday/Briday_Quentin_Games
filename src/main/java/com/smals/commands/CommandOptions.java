package com.smals.commands;


public enum CommandOptions {
    SHOW_FIRST_GAME_CATEGORY("Show the first game category", new ShowFirstGameCategoryCommand())
    , SHOW_FIFTH_GAME("Show the fifth game", new ShowFifthGameCommand())
    , SHOW_FIRST_BORROWER("Show the first borrower", new ShowFirstBorrowerCommand())
    , SHOW_CHOICE_GAME("Show a game of your choice", new ShowChoiceGameCommand())
    , SHOW_ALL_GAMES("Show all games", new ShowAllGamesCommand())
    , SHOW_GAMES_AND_CHOOSE("Show a list of games and choose a game", new ShowGameAndChooseCommand())
    , SHOW_BORROWED_GAMES("Show borrowed games", new ShowBorrowedGamesCommand())
    , ADVANCED_SEARCH_DIFFICULTY("Advanced search : difficulty", new AdancedSearchDifficultyCommand());

    private final String description;
    private final Command command;

    CommandOptions(String description, Command command) {
        this.description = description;
        this.command = command;
    }

    public String getDescription() {
        return description;
    }

    public Command getCommand() {
        return command;
    }
}
