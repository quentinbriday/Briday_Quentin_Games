package com.smals.commands;

import com.smals.domain.Borrow;
import com.smals.service.BorrowService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class ShowBorrowedGamesCommand implements Command {
    @Override
    public void execute() {
        List<Borrow> borrows = new BorrowService().findAllBorrow();
        //columnPrintingBorrow(borrows);
        boolean loop = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (loop) {
            System.out.println("Do you want to search for a borrower ?\n" +
                    "Enter part of the name of a borrower to search it, or 'exit' if  you want to stop." +
                    "\nLeave empty if you want to see all the borrows");
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

    private static void columnPrintingBorrow(List<Borrow> borrows){
        System.out.printf("%-30.30s  %-30.30s %-30.30s %-30.30s%n", "-- GAME --", "-- BORROWER --", "-- BORROW DATE--", "-- RETURN DATE--");
        borrows.forEach(b -> {
            System.out.printf("%-30.30s  %-30.30s %-30.30s %-30.30s%n", b.getGame().getGameName(), b.getBorrower().getBorrowerName(), b.getBorrowDate(), b.getReturnDate());
        });
    }
}
