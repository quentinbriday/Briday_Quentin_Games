package com.smals;

import com.smals.domain.Borrow;
import com.smals.domain.Game;
import com.smals.service.GameService;

import javax.swing.text.html.Option;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static GameService gameService = new GameService();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static void main(String[] args) {
        System.out.println("----- Briday_Quentin_Games, by Briday Quentin -----");

        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while(loop) {
            System.out.println("Choose an option :");
            System.out.println(ANSI_BLUE + "1. "+ ANSI_RESET + "Show the first game category");
            System.out.println(ANSI_BLUE + "2. "+ ANSI_RESET + "Show the fifth game");
            System.out.println(ANSI_BLUE + "3. "+ ANSI_RESET + "Show the first borrower");
            System.out.println(ANSI_BLUE + "4. "+ ANSI_RESET + "Show a game of your choice");
            System.out.println(ANSI_BLUE + "5. "+ ANSI_RESET + "Show all games");
            System.out.println(ANSI_BLUE + "6. "+ ANSI_RESET + "Show a list of games and choose a game");
            System.out.println(ANSI_BLUE + "7. "+ ANSI_RESET + "Show borrowed games");
            System.out.println(ANSI_BLUE + "99. "+ ANSI_RESET + "Exit the program");
            try{
                System.out.print("Your choice --> ");
                int option = scanner.nextInt();
                switch (option){
                    case 1:
                        System.out.println(gameService.findGameCategoryById(1));
                        break;
                    case 2:
                        System.out.println(gameService.findGameById(5));
                        break;
                    case 3:
                        System.out.println(gameService.findBorrowerById(1));
                        break;
                    case 4:
                        showUserChoiceGame();
                        break;
                    case 5:
                        List<Game> games = gameService.findAllGames();
                        for (Game g : games){
                            System.out.println(g.getGameName() + " :\n   "
                            + "editor : " + g.getEditor() + "\n   "
                            + "price : " + g.getPrice());
                        }
                        break;
                    case 6:
                        showGamesAndUserChoseOne();
                        break;
                    case 7:
                        showAllBorrowedGames();
                        break;
                    case 99:
                        loop = false;
                        break;
                    default:
                        System.out.println("You do not have chose a right number. Please chose again.");
                }
            }catch (InputMismatchException ex){
                System.out.println("Please, put only number in this menu selection.");
                scanner.next();
            }
        }
        System.out.println("Goodbye !");
        scanner.close();
    }

    private static void columnPrintingBorrow(List<Borrow> borrows){
        System.out.printf("%-30.30s  %-30.30s %-30.30s %-30.30s%n", "-- GAME --", "-- BORROWER --", "-- BORROW DATE--", "-- RETURN DATE--");
        borrows.forEach(b -> {
            System.out.printf("%-30.30s  %-30.30s %-30.30s %-30.30s%n", b.getGame().getGameName(), b.getBorrower().getBorrowerName(), b.getBorrowDate(), b.getReturnDate());
        });
    }

    private static void showAllBorrowedGames() {
        List<Borrow> borrows = gameService.findAllBorrow();
        //columnPrintingBorrow(borrows);
        boolean loop = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (loop) {
            System.out.println("Do you want to search for a borrower ?\n" +
                    "Enter part of the name of a borrower to search it, or 'exit' if  you want to stop.\nLeave empty if you want to see all the borrows");
            System.out.print("Your research --> ");
            try {
                String name = reader.readLine();
                if (name.equals("exit")){
                    loop = false;
                }
                else{
                    List<Borrow> tempBorrow = borrows.stream().filter(b -> b.getBorrower().getBorrowerName().toUpperCase().contains(name.toUpperCase())).collect(Collectors.toList());
                    if (tempBorrow.isEmpty()){
                        System.err.println("There is no borrower with this name");
                    }
                    else{
                        columnPrintingBorrow(tempBorrow);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                loop = false;
            }
        }
    }

    private static void showGamesAndUserChoseOne() {
        List<Game> games = gameService.findAllGames();
        for (Game g : games){
            System.out.println(g.getGameName() + ", category : " + g.getCategory().getCategoryName());
        }
        System.out.println("Now please, enter part of the name of the game you choose : ");
        System.out.print("Your research --> ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String gameName = reader.readLine();
            if (games.stream().filter(g -> g.getGameName().toUpperCase().contains(gameName.toUpperCase())).findFirst().isPresent()){
                System.out.println(games.stream().filter(g -> g.getGameName().toUpperCase().contains(gameName.toUpperCase())).findFirst().get());
            }
            else{
                System.err.println("There is no game with a name matching " + gameName);
            }
            System.out.print("Press the enter key to continue...");
            try {
                reader.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void showUserChoiceGame() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please, now enter part of the title of the game you're searching");
        System.out.print("Your research --> ");
        String gameName = null;
        try {
            gameName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Game game = gameService.findGameByName(gameName);
        if (game == null){
            System.err.println("The game you're searching doesn't exist in our database.");
        }
        else{
            System.out.println(game.getGameName() + " : \n   publisher : " + game.getEditor()
                + "\n   age : " + game.getAge()
                + "\n   price : " + game.getPrice());
        }
        System.out.print("Press the enter key to continue...");
        try {
            reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
