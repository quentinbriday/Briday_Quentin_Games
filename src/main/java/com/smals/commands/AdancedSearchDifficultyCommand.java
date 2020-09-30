package com.smals.commands;

import com.smals.domain.Difficulty;
import com.smals.domain.Game;
import com.smals.domain.enums.DifficultyType2;
import com.smals.service.GameService;

import java.util.*;
import java.util.stream.Collectors;

public class AdancedSearchDifficultyCommand implements Command {
    @Override
    public void execute() {
        //TODO: Replace BufferReader by scanner, way more easier to control if the input is right
        List<Game> games = new GameService().findAllGames();
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while(loop){
            System.out.println("Choose a difficulty level (enter the number) :");
            Arrays.stream(DifficultyType2.values())
                    .forEach(difficultyType2 -> System.out.println(difficultyType2.ordinal() + ". " + difficultyType2.getDescription()));
            System.out.print("Your choice --> ");
            try {
                int i = scanner.nextInt();
                if (i < 0 || i > 4) {
                    System.err.println("Please, enter a correct number");
                } else {
                    Optional<DifficultyType2> optionalDifficultyType2 = Arrays.stream(DifficultyType2.values())
                            .filter(difficultyType2 -> difficultyType2.ordinal() == i)
                            .findFirst();
                    if (optionalDifficultyType2.isPresent()) {
                        List<Game> filteredList = games.stream()
                                .filter(g -> Difficulty.equalOrMore(g.getDifficulty(), optionalDifficultyType2.get()))
                                .collect(Collectors.toList());
                        filteredList.forEach(System.out::println);
                        loop = false;
                    }
                }
            } catch (InputMismatchException e) {
                System.err.println("Please, insert a number");
            }
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        while(loop) {
//            System.out.println("Choose a difficulty level (enter the number) :");
//            System.out.println("1. Very easy\n2. Easy\n3. Average\n4. Difficult\n5. Very difficult");
//            System.out.print("Your choice --> ");
//            try {
//                boolean levelValidate = false;
//                String level = "5";
//                int i = 0;
//                while(!levelValidate) {
//                    level = reader.readLine();
//                    i = Integer.parseInt(String.valueOf(level.charAt(0)));
//                    if (i < 1 || i > 5){
//                        System.err.println("Please, enter a correct number");
//                    }
//                    else{
//                        levelValidate = true;
//                    }
//                }
//                final int finalI = i-1;
//                DifficultyType[] difficultyTypes = DifficultyType.values();
//                List<Game> filteredList = games.stream()
//                        .filter(g -> Difficulty.equalOrMore(g.getDifficulty(), difficultyTypes[finalI]))
//                        .collect(Collectors.toList());
//                filteredList.forEach(System.out::println);
        }
    }
}
