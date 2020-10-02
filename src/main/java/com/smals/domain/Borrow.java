package com.smals.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Borrow implements Serializable {

    private Integer id;
    private Game game;
    private Borrower borrower;
    private Date borrowDate;
    private Date returnDate;

    public Borrow(Integer id, Game game, Borrower borrower, Date borrowDate, Date returnDate) {
        this.id = id;
        this.game = game;
        this.borrower = borrower;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", game=" + game +
                ", borrower=" + borrower +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
