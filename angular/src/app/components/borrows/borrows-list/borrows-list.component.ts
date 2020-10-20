import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {Game} from '../../models/game';
import {GamesService} from '../../games/games.service';
import {Borrows} from '../../models/borrows';
import {BorrowersService} from '../../borrowers/borrowers.service';
import {BorrowsService} from '../borrows.service';

@Component({
  selector: 'app-borrows-list',
  templateUrl: './borrows-list.component.html',
  styleUrls: ['./borrows-list.component.css']
})
export class BorrowsListComponent implements OnInit {

  borrows: Observable<Borrows[]>;
  displayedColumns: string[] = ['game', 'borrower', 'borrowDate', 'returnDate', 'actions'];

  constructor(private borrowsService: BorrowsService) { }

  ngOnInit(): void {
    this.getBorrows();
  }

  getBorrows(): void{
    this.borrows = this.borrowsService.findAllBorrows();
  }

}
