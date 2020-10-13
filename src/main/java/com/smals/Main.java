//package com.smals;
//
//import com.smals.commands.CommandOptions;
//import com.smals.commands.GamesWorker;
//
//import java.util.*;
//
//import static java.lang.Thread.sleep;
//
//public class Main {
//    private static final String ANSI_RESET = "\u001B[0m";
//    private static final String ANSI_BLUE = "\u001B[34m";
//    private static Scanner scanner = new Scanner(System.in);
//    private static boolean loop = true;
//
//    public static void main(String[] args) {
//        System.out.println("----- Briday_Quentin_Games, by Briday Quentin -----");
//        start();
//        scanner.close();
//    }
//
//    private static void start() {
//        while (loop) {
//            try {
//                System.out.println("What do you want to do?");
//                showAvailableCommands();
//                Optional<CommandOptions> commandOption = getCommandOption();
//                commandOption.ifPresent(commandOptions -> new GamesWorker().doWork(commandOptions.getCommand()));
//                System.out.println("Press the enter key to continue...");
//                scanner.nextLine();
//                scanner.nextLine();
//            } catch (InputMismatchException e) {
//                System.err.println("Please, enter only a number");
//                scanner.next();
//                try {
//                    sleep(1500);
//                } catch (InterruptedException ex) {
//                    ex.printStackTrace();
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        System.out.println("Goodbye !");
//    }
//
//    private static Optional<CommandOptions> getCommandOption() throws InterruptedException {
//        System.out.print("Choose a command --> ");
//        int commandNumber = scanner.nextInt();
//
//        if (commandNumber == 99) {
//            loop = false;
//            return Optional.empty();
//        }
//        Optional<CommandOptions> optionalCommandOptions = Arrays.stream(CommandOptions.values())
//                .filter(commandOptions -> commandOptions.ordinal() == commandNumber)
//                .findFirst();
//        if (!optionalCommandOptions.isPresent()) {
//            System.err.println("Give in a correct number!");
//            sleep(1500);
//            start();
//        }
//        return optionalCommandOptions;
//    }
//
//    private static void showAvailableCommands() {
//        Arrays.stream(CommandOptions.values())
//                .forEach(commandOptions -> System.out.println(ANSI_BLUE + commandOptions.ordinal() + ". " + ANSI_RESET + commandOptions.getDescription()));
//        System.out.println(ANSI_BLUE + "99. " + ANSI_RESET + "Exit");
//    }
//}
