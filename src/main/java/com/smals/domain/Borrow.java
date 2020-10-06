package com.smals.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Borrow implements Serializable {

    @Id @GeneratedValue
    private Integer id;
    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id")
    private Game game;
    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "borrower_id")
    private Borrower borrower;
    @Temporal(TemporalType.DATE)
    @Column(name = "borrow_date", nullable = false)
    private Date borrowDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "return_date")
    private Date returnDate;

    public Borrow(){}

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
